package sample;

import com.sun.javafx.binding.StringFormatter;
import com.sun.org.apache.xml.internal.security.utils.IgnoreAllErrorHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import static java.lang.Double.isFinite;
import static java.lang.Double.parseDouble;

public class SimpleSaving {

    public static void display() throws FileNotFoundException {
        Stage window = new Stage();
        Scene keyBoardScene;
        window.setTitle("Simple Savings");

        //creating a new Decimal Formatter
        DecimalFormat df = new DecimalFormat("#.##");


        //Creating the TextFields
        Text futureValueText = new Text("Future Value");
        Text presentValueText = new Text("Present Value");
        Text interestRateText = new Text("Interest Rate");
        Text yearsText = new Text("Time in Years");

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setId("keyboardButton");
        calculateBtn.setLayoutX(60);
        calculateBtn.setLayoutY(500);

        Button resetBtn = new Button("Reset");
        resetBtn.setId("keyboardButton");
        resetBtn.setLayoutX(250);
        resetBtn.setLayoutY(500);


        futureValueText.setId("fdText");
        presentValueText.setId("fdText");
        interestRateText.setId("fdText");
        yearsText.setId("fdText");

        futureValueText.setLayoutX(60);
        futureValueText.setLayoutY(220);

        presentValueText.setLayoutX(60);
        presentValueText.setLayoutY(290);

        interestRateText.setLayoutX(60);
        interestRateText.setLayoutY(360);

        yearsText.setLayoutX(60);
        yearsText.setLayoutY(430);


        TextField futureValueField = createTextField(300,180,150,60,"futureValueField");
        TextField presentValueField =    createTextField(300,250,150,60,"presentValueField");
        TextField interestRateField =   createTextField(300,320,150,60,"interestRateField");
        TextField yearsField =          createTextField(300,390,150,60,"yearsField");


        //Reading the TempFile and assigning the values to the textFields
        List<String> readList = FileReadTemp.read("./simpleSavingTemp.txt");
        futureValueField.setText(readList.get(0));
        presentValueField.setText(readList.get(1));
        interestRateField.setText(readList.get(2));
        yearsField.setText(readList.get(3));



        calculateBtn.setOnAction(event -> {


            //Clearing the TempFile after clicking the calculate button
            try {
                FileTempoWrite.simpleSaving("simpleSavingTemp.txt"," "," "," "," ");
            } catch (IOException e) {
                e.printStackTrace();
            }


//            window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
            if(TextFieldValidate.check(futureValueField,presentValueField,interestRateField,yearsField)==0){

                WarningBox.display("Everything filled","Leave the field which want to Calculate Blank");

            }else if(TextFieldValidate.check(futureValueField,presentValueField,interestRateField,yearsField)>1){

                WarningBox.display("Lack on Values","Leave Only 1 field Blank");

            }
//            else if(TextFieldValidate.stringCheck(futureValueField.getText(),presentValueField.getText(),interestRateField.getText(),yearsField.getText())==2){
//                WarningBox.display("Strings are not Allowed","Only Numerical values are accepted");
//                futureValueField.clear();
//                presentValueField.clear();
//                interestRateField.clear();
//                yearsField.clear();

            else if(TextFieldValidate.check(futureValueField,presentValueField,interestRateField,yearsField)==1 && futureValueField.getText().trim().isEmpty()){
                //calculating the Future Value


                double presentValue = parseDouble(presentValueField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double years = parseDouble(yearsField.getText());
                double nOF = 12.0;

                double futureValeOutcome = presentValue*Math.pow(((1+(interestRate/nOF))),(nOF*years));
                try{
                    double outcome = Double.valueOf(df.format(futureValeOutcome));
                    futureValueField.setText(String.valueOf(outcome));
                    try {
                        FileWrite.simpleSaving("simpleSaving.txt",outcome,presentValue,interestRate,years);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }catch (NumberFormatException e){
                    WarningBox.display("Infinity","Your Answer results in Infinity");
                }




            }else if(TextFieldValidate.check(futureValueField,presentValueField,interestRateField,yearsField)==1 && presentValueField.getText().trim().isEmpty()){
                //calculating the present value

                double futureValue = parseDouble(futureValueField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double years = parseDouble(yearsField.getText());
                double nOF = 12.0;

                double presentValueOutcome = futureValue/Math.pow(1+(interestRate/nOF),(nOF*years));
                double outcome = Double.valueOf(df.format(presentValueOutcome));
                presentValueField.setText(String.valueOf(outcome));

                try {
                    FileWrite.simpleSaving("simpleSaving.txt",futureValue,outcome,interestRate,years);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldValidate.check(futureValueField,presentValueField,interestRateField,yearsField)==1 && interestRateField.getText().trim().isEmpty()){
                //calculating the Interest Rate

                double futureValue = parseDouble(futureValueField.getText());
                double presentValue = parseDouble(presentValueField.getText());
                double years = parseDouble(yearsField.getText());
                double nOF = 12.0;

//                double interestRateOutcome = nOF*(Math.pow((futureValue/presentValue),(1/(nOF*years))-1));
                double interestRateOutcome = nOF * ((Math.pow((futureValue / presentValue), (1/(nOF * years)))) - 1);
                double outcome = Double.valueOf(df.format(interestRateOutcome*100));
                interestRateField.setText(String.valueOf(outcome));

                try {
                    FileWrite.simpleSaving("simpleSaving.txt",futureValue,presentValue,outcome,years);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(TextFieldValidate.check(futureValueField,presentValueField,interestRateField,yearsField)==1 && yearsField.getText().trim().isEmpty()){
                //calculating the years

                double futureValue = parseDouble(futureValueField.getText());
                double presentValue = parseDouble(presentValueField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double nOF = 12.0;

//                double yearsOutcome = (Math.log(futureValue/presentValue))/nOF*(Math.log(1+(interestRate/nOF)));
                double yearsOutcome = (Math.log(futureValue/presentValue)) / (nOF * (Math.log(1 + (interestRate/nOF))));
                double outcome = Double.valueOf(df.format(yearsOutcome));
                yearsField.setText(String.valueOf(outcome));

                try {
                    FileWrite.simpleSaving("simpleSaving.txt",futureValue,presentValue,interestRate,outcome);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        resetBtn.setOnAction(e->{
            futureValueField.clear();
            presentValueField.clear();
            interestRateField.clear();
            yearsField.clear();
        });




        Pane simpleSavingPane = new Pane();

        simpleSavingPane.getChildren().addAll(
                futureValueText,presentValueText,interestRateText,yearsText,Keyboard.displayKeyboard(130,40,futureValueField,presentValueField,interestRateField,yearsField),
                presentValueField,interestRateField,yearsField,calculateBtn, futureValueField, resetBtn,TopBar.display(window,0,10)
        );

        keyBoardScene = new Scene(simpleSavingPane,900,700);
        keyBoardScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());
        simpleSavingPane.setStyle("-fx-background-color: #e1ffc2;");

        window.setScene(keyBoardScene);
        window.show();


        //Writing into the TempFile when the close button is clicked
        window.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST,event -> {
            try {
                FileTempoWrite.simpleSaving("simpleSavingTemp.txt",futureValueField.getText(),presentValueField.getText(),interestRateField.getText(),yearsField.getText());
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
