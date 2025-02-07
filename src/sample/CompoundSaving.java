package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import static java.lang.Double.parseDouble;

public class CompoundSaving {

    public static void display() throws FileNotFoundException {
        Stage window = new Stage();
        Scene keyBoardScene;
        window.setTitle("Compound Savings");

        //creating an object to round the Decimal
        DecimalFormat df = new DecimalFormat("#.##");

        //creating the text
        Text futureValueText = new Text("Future Value");
        Text presentValueText = new Text("Present Value");
        Text interestRateText = new Text("Interest Rate");
        Text monthlyPaymentText = new Text("Monthly Payments");
        Text yearsText = new Text("Time in Years");

        //creating the calculate button
        Button calculateBtn = new Button("Calculate");
        calculateBtn.setId("keyboardButton");
        calculateBtn.setLayoutX(90);
        calculateBtn.setLayoutY(570);

        //creating the reset button
        Button resetBtn = new Button("Reset");
        resetBtn.setId("keyboardButton");
        resetBtn.setLayoutX(320);
        resetBtn.setLayoutY(570);


        //Setting the ID
        futureValueText.setId("fdText");
        presentValueText.setId("fdText");
        interestRateText.setId("fdText");
        yearsText.setId("fdText");
        monthlyPaymentText.setId("fdText");

        //placing the elements by setting coordinates
        futureValueText.setLayoutX(50);
        futureValueText.setLayoutY(220);

        presentValueText.setLayoutX(50);
        presentValueText.setLayoutY(290);

        interestRateText.setLayoutX(50);
        interestRateText.setLayoutY(360);

        monthlyPaymentText.setLayoutX(50);
        monthlyPaymentText.setLayoutY(430);

        yearsText.setLayoutX(50);
        yearsText.setLayoutY(500);

        Label headText = new Label("Compound Saving");
        headText.setLayoutX(10);
        headText.setLayoutY(50);
        headText.setId("headText");

        //creating textfields from a method
        TextField futureValueField =        createTextField(300,180,150,60,"futureValueField");
        TextField presentValueField =       createTextField(300,250,150,60,"presentValueField");
        TextField interestRateField =       createTextField(300,320,150,60,"interestRateField");
        TextField monthlyPaymentField =     createTextField(300,390,150,60,"yearsField");
        TextField yearsField =              createTextField(300,460,150,60,"yearsField");

        //repopulating the unsaved input fields
        List<String> readList = FileReadTemp.read("./compoundSavingTemp.txt");
        futureValueField.setText(readList.get(0));
        presentValueField.setText(readList.get(1));
        interestRateField.setText(readList.get(2));
        monthlyPaymentField.setText(readList.get(3));
        yearsField.setText(readList.get(4));


        calculateBtn.setOnAction(event -> {

            try {
                FileTempoWrite.compoundSaving("compoundSavingTemp.txt"," "," "," "," "," ");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(TextFieldValidate.check(futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField)==0){
                //calling the warning box for leaving more than one input fields
                WarningBox.display("Everything filled","Leave the field which want to Calculate Blank");

            }else if(TextFieldValidate.check(futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField)>1){
                //calling the warning box for filling all the fields
                WarningBox.display("Lack on Values","Leave Only 1 field Blank");

            }else if(TextFieldValidate.check(futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField)==1 && futureValueField.getText().trim().isEmpty()){
                //calculate future value

                double presentValue = parseDouble(presentValueField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double years = parseDouble(yearsField.getText());
                double payment = parseDouble(monthlyPaymentField.getText());
                double nOF = 12.0;

                double futureValeOutcome = ((presentValue*Math.pow(1+(interestRate/nOF),nOF*years))+payment*(((Math.pow((1+(interestRate/nOF)),(nOF*years)))-1)/(interestRate/nOF)));
                double outcome = Double.valueOf(df.format(futureValeOutcome));
                futureValueField.setText(String.valueOf(outcome));

                try {
                    FileWrite.compoundSaving("compoundSaving.txt",outcome,presentValue,interestRate,payment,years);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldValidate.check(futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField)==1 && presentValueField.getText().trim().isEmpty()){
                //calculate present value

                double futureValue = parseDouble(futureValueField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double years = parseDouble(yearsField.getText());
                double payment = parseDouble(monthlyPaymentField.getText());
                double nOF = 12.0;

                double presentValueOutcome = ((futureValue-(payment*(((Math.pow((1+(interestRate/nOF)),(nOF*years)))-1)/(interestRate/nOF))))/(Math.pow((1+(interestRate/nOF)),(nOF*years))));
                double outcome = Double.valueOf(df.format(presentValueOutcome));
                presentValueField.setText(String.valueOf(outcome));

                try {
                    FileWrite.compoundSaving("compoundSaving.txt",futureValue,outcome,interestRate,payment,years);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldValidate.check(futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField)==1 && interestRateField.getText().trim().isEmpty()){
                WarningBox.display("Interest Rate cannot be calculated","Please try calculating some other field");
            }else if(TextFieldValidate.check(futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField)==1 && yearsField.getText().trim().isEmpty()){
                //calculate years

                double futureValue = parseDouble(futureValueField.getText());
                double presentValue = parseDouble(presentValueField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double payment = parseDouble(monthlyPaymentField.getText());
                double nOF = 12.0;

                double yearsOutcome =  (Math.log((((interestRate*futureValue)/nOF)+payment)/(((presentValue*interestRate)/nOF)+payment))/(nOF*(Math.log((1+(interestRate/nOF))))));
                double outcome = Double.valueOf(df.format(yearsOutcome));
                yearsField.setText(String.valueOf(outcome));

                try {
                    FileWrite.compoundSaving("compoundSaving.txt",futureValue,presentValue,interestRate,payment,outcome);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldValidate.check(futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField)==1 && monthlyPaymentField.getText().trim().isEmpty()){
                //calculate monthly payment
                double futureValue = parseDouble(futureValueField.getText());
                double presentValue = parseDouble(presentValueField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double years = parseDouble(yearsField.getText());
                double nOF = 12.0;

                double paymentOutcome = ((futureValue-(presentValue*Math.pow((1+(interestRate/nOF)),(nOF*years))))/((Math.pow((1+(interestRate/nOF)),(nOF*years))-1)/(interestRate/nOF)));
                double outcome = Double.valueOf(df.format(paymentOutcome));
                monthlyPaymentField.setText(String.valueOf(outcome));

                try {
                    FileWrite.compoundSaving("compoundSaving.txt",futureValue,presentValue,interestRate,outcome,years);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //reset button
        resetBtn.setOnAction(e->{
            futureValueField.clear();
            presentValueField.clear();
            interestRateField.clear();
            monthlyPaymentField.clear();
            yearsField.clear();
        });

        Pane root2 = new Pane();
        root2.getChildren().addAll(
                futureValueText,presentValueText,interestRateText,monthlyPaymentText,yearsText,Keyboard.displayKeyboard(130,30,futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField),
                presentValueField,interestRateField,monthlyPaymentField,yearsField,calculateBtn, futureValueField, resetBtn,TopBar.display(window,0,10),headText
        );

        keyBoardScene = new Scene(root2,900,700);
        keyBoardScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());
        root2.setStyle("-fx-background-color: #eac761;");

        window.setScene(keyBoardScene);
        window.show();

        //Writing into temporary file when the UI close button is clicked
        window.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
            try {
                FileTempoWrite.compoundSaving("compoundSavingTemp.txt",futureValueField.getText(),presentValueField.getText(),interestRateField.getText(),monthlyPaymentField.getText(),yearsField.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    //Method to create TextFields
    private static TextField createTextField(double x, double y, double j, double k,String id){
        TextField textField = new TextField();
        textField.setLayoutX(x);
        textField.setLayoutY(y);
        textField.setId(id);
        textField.setPrefSize(j,k);

        return textField;
    }


}
