package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static java.lang.Double.parseDouble;

public class CompoundSaving {

    public static void display() throws FileNotFoundException {
        Stage window = new Stage();
        Scene keyBoardScene;
        window.setTitle("Compound Savings");

        Text futureValueText = new Text("Future Value");
        Text presentValueText = new Text("Present Value");
        Text interestRateText = new Text("Interest Rate");
        Text monthlyPaymentText = new Text("Monthly Payments");
        Text yearsText = new Text("Time in Years");

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setId("keyboardButton");
        calculateBtn.setLayoutX(60);
        calculateBtn.setLayoutY(600);

        Button resetBtn = new Button("Reset");
        resetBtn.setId("keyboardButton");
        resetBtn.setLayoutX(250);
        resetBtn.setLayoutY(600);


        futureValueText.setId("fdText");
        presentValueText.setId("fdText");
        interestRateText.setId("fdText");
        yearsText.setId("fdText");
        monthlyPaymentText.setId("fdText");

        futureValueText.setLayoutX(60);
        futureValueText.setLayoutY(220);

        presentValueText.setLayoutX(60);
        presentValueText.setLayoutY(290);

        interestRateText.setLayoutX(60);
        interestRateText.setLayoutY(360);

        monthlyPaymentText.setLayoutX(60);
        monthlyPaymentText.setLayoutY(430);

        yearsText.setLayoutX(60);
        yearsText.setLayoutY(500);



//        TextField futureValueField =     createTextField(300,180,120,60,"futureValueField");
        TextField futureValueField =        createTextField(300,180,120,60,"futureValueField");
        TextField presentValueField =       createTextField(300,250,120,60,"presentValueField");
        TextField interestRateField =       createTextField(300,320,120,60,"interestRateField");
        TextField monthlyPaymentField =     createTextField(300,390,120,60,"yearsField");
        TextField yearsField =              createTextField(300,460,120,60,"yearsField");

        List<String> readList = FileReadTemp.read("./compoundSavingTemp.txt");
        futureValueField.setText(readList.get(0));
        presentValueField.setText(readList.get(1));
        interestRateField.setText(readList.get(2));
        monthlyPaymentField.setText(readList.get(3));
        yearsField.setText(readList.get(4));
//        try {
//            FileTempoWrite.compoundSaving("compoundSavingTemp.txt"," "," "," "," "," ");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        installListener(futureValueField,presentValueField,interestRateField,yearsField);

        calculateBtn.setOnAction(event -> {

            try {
                FileTempoWrite.compoundSaving("compoundSavingTemp.txt"," "," "," "," "," ");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(TextFieldEmptyCheck.check(futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField)==0){

                WarningBox.display("Everything filled","Leave the field which want to Calculate Blank");

            }else if(TextFieldEmptyCheck.check(futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField)>1){

                WarningBox.display("Lack on Values","Leave Only 1 field Blank");

            }else if(TextFieldEmptyCheck.check(futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField)==1 && futureValueField.getText().trim().isEmpty()){
                //calculate future value

                double presentValue = parseDouble(presentValueField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double years = parseDouble(yearsField.getText());
                double payment = parseDouble(monthlyPaymentField.getText());
                double nOF = 12.0;

                double futureValeOutcome = ((presentValue*Math.pow(1+(interestRate/nOF),nOF*years))+payment*(((Math.pow((1+(interestRate/nOF)),(nOF*years)))-1)/(interestRate/nOF)));
                futureValueField.setText(String.valueOf(futureValeOutcome));

                try {
                    FileWrite.compoundSaving("compoundSaving.txt",futureValeOutcome,presentValue,interestRate,payment,years);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldEmptyCheck.check(futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField)==1 && presentValueField.getText().trim().isEmpty()){
                //calculate present value

                double futureValue = parseDouble(futureValueField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double years = parseDouble(yearsField.getText());
                double payment = parseDouble(monthlyPaymentField.getText());
                double nOF = 12.0;

                double presentValueOutcome = ((futureValue-(payment*(((Math.pow((1+(interestRate/nOF)),(nOF*years)))-1)/(interestRate/nOF))))/(Math.pow((1+(interestRate/nOF)),(nOF*years))));
                presentValueField.setText(String.valueOf(presentValueOutcome));

                try {
                    FileWrite.compoundSaving("compoundSaving.txt",futureValue,presentValueOutcome,interestRate,payment,years);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldEmptyCheck.check(futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField)==1 && interestRateField.getText().trim().isEmpty()){
                //calculate interestRateField
                //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Still NO:::::::::::::::::::::::::::::::::::::://

                double futureValue = parseDouble(futureValueField.getText());
                double presentValue = parseDouble(presentValueField.getText());
                double years = parseDouble(yearsField.getText());
                double payment = parseDouble(monthlyPaymentField.getText());
                double nOF = 12.0;

                double interestRateOutcome = nOF*(Math.pow((futureValue/presentValue),(1/nOF*years))-1);
                interestRateField.setText(String.valueOf(interestRateOutcome));

                System.out.println("calculate Interest");
            }else if(TextFieldEmptyCheck.check(futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField)==1 && yearsField.getText().trim().isEmpty()){
                //calculate years

                double futureValue = parseDouble(futureValueField.getText());
                double presentValue = parseDouble(presentValueField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double payment = parseDouble(monthlyPaymentField.getText());
                double nOF = 12.0;

                double yearsOutcome =  (Math.log((((interestRate*futureValue)/nOF)+payment)/(((presentValue*interestRate)/nOF)+payment))/(nOF*(Math.log((1+(interestRate/nOF))))));
                yearsField.setText(String.valueOf(yearsOutcome));

                try {
                    FileWrite.compoundSaving("compoundSaving.txt",futureValue,presentValue,interestRate,payment,yearsOutcome);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldEmptyCheck.check(futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField)==1 && monthlyPaymentField.getText().trim().isEmpty()){
                //calculate monthly payment
                double futureValue = parseDouble(futureValueField.getText());
                double presentValue = parseDouble(presentValueField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double years = parseDouble(yearsField.getText());
                double nOF = 12.0;

                double paymentOutcome = ((futureValue-(presentValue*Math.pow((1+(interestRate/nOF)),(nOF*years))))/((Math.pow((1+(interestRate/nOF)),(nOF*years))-1)/(interestRate/nOF)));
                monthlyPaymentField.setText(String.valueOf(paymentOutcome));

                try {
                    FileWrite.compoundSaving("compoundSaving.txt",futureValue,presentValue,interestRate,paymentOutcome,years);
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });

        resetBtn.setOnAction(e->{
            futureValueField.clear();
            presentValueField.clear();
            interestRateField.clear();
            monthlyPaymentField.clear();
            yearsField.clear();
        });

        activeCheck(futureValueField,presentValueField,interestRateField,yearsField);



//        Button btnBack = new Button("Back");
//        btnBack.setId("backBtn");
//        btnBack.setLayoutX(10);
//        btnBack.setLayoutY(10);
//
//        btnBack.setOnAction(e -> {
//            window.close();
//            HomePage.display();
//        });

        Pane root2 = new Pane();
        root2.getChildren().addAll(
                futureValueText,presentValueText,interestRateText,monthlyPaymentText,yearsText,Keyboard.displayKeyboard(200,40,futureValueField,presentValueField,interestRateField,monthlyPaymentField,yearsField),
                presentValueField,interestRateField,monthlyPaymentField,yearsField,calculateBtn, futureValueField, resetBtn,TopBar.display(window,0,10)
        );

        keyBoardScene = new Scene(root2,900,700);
        keyBoardScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());
        root2.setStyle("-fx-background-color: #f7cccc;");

        window.setScene(keyBoardScene);
        window.show();

        //When the UI close Button is Clicked;
        window.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
            try {
                FileTempoWrite.compoundSaving("compoundSavingTemp.txt",futureValueField.getText(),presentValueField.getText(),interestRateField.getText(),monthlyPaymentField.getText(),yearsField.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }



























    private static int checkAll(TextField... textFields){
        int count = 0;
        for(TextField textField : textFields){
            if (textField.getText().trim().isEmpty()){
                count++;
            }
        }
//        System.out.println(count);
        return count;
    }

    private static void activeCheck(TextField... textFields){
        for (TextField textField : textFields) {
            textField.focusedProperty().addListener((observableValue, oldValue, newValue) -> {
//                System.out.println(textField.getId()+" is Active");
                String active = textField.getId();
            });
        }
    }



    private static TextField createTextField(double x, double y, double j, double k,String id){
        TextField textField = new TextField();
        textField.setLayoutX(x);
        textField.setLayoutY(y);
        textField.setId(id);
        textField.setPrefSize(j,k);

        return textField;
    }

    private static void installListener(TextField... textFields) {

        // Install the same listener on all of them
        for (TextField textField : textFields) {
            textField.focusedProperty().addListener((observableValue, oldValue, newValue) -> {

                // Set the selectedTextField to null whenever focus is lost. This accounts for the
                // TextField losing focus to another control that is NOT a TextField
                TextField selectedTextField = null;

                if (newValue) {
                    // The new textfield is focused, so set the global reference
                    selectedTextField = textField;
//                    System.out.println("Selected Text: " + selectedTextField.getText());
                }
            });
        }
    }
}
