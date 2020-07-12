package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
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

public class Mortgage{

    public static void display() throws FileNotFoundException {
        Stage window = new Stage();
        Scene keyBoardScene;
        window.setTitle("Mortgage");

        //creating a new Decimal Formatter
        DecimalFormat df = new DecimalFormat("#.##");

        Text mortgageAmountText = new Text("Mortgage Amount");
        Text mortgageTermText = new Text("Mortgage Term");
        Text interestRateText = new Text("Interest Rate");
        Text monthPaymentText = new Text("Month Payment");
        Text downPaymentText = new Text("Down Payment");

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setId("keyboardButton");
        calculateBtn.setLayoutX(90);
        calculateBtn.setLayoutY(570);

        Button resetBtn = new Button("Reset");
        resetBtn.setId("keyboardButton");
        resetBtn.setLayoutX(320);
        resetBtn.setLayoutY(570);

        mortgageAmountText.setId("fdText");
        mortgageTermText.setId("fdText");
        interestRateText.setId("fdText");
        monthPaymentText.setId("fdText");
        downPaymentText.setId("fdText");

        mortgageAmountText.setLayoutX(50);
        mortgageAmountText.setLayoutY(220);

        downPaymentText.setLayoutX(50);
        downPaymentText.setLayoutY(290);

        mortgageTermText.setLayoutX(50);
        mortgageTermText.setLayoutY(360);

        interestRateText.setLayoutX(50);
        interestRateText.setLayoutY(430);

        monthPaymentText.setLayoutX(50);
        monthPaymentText.setLayoutY(500);


        TextField mortgageAmountField =     createTextField(300,180,150,60,"futureValueField");
        TextField downPaymentField =        createTextField(300,250,150,60,"futureValueField");
        TextField mortgageTermField =       createTextField(300,320,150,60,"presentValueField");
        TextField interestRateField =       createTextField(300,390,150,60,"interestRateField");
        TextField monthField =              createTextField(300,460,150,60,"yearsField");


        List<String> readList = FileReadTemp.read("./mortgageTemp.txt");
        mortgageAmountField.setText(readList.get(0));
        downPaymentField.setText(readList.get(1));
        mortgageTermField.setText(readList.get(2));
        interestRateField.setText(readList.get(3));
        monthField.setText(readList.get(4));


        calculateBtn.setOnAction(event -> {

            try {
                FileTempoWrite.mortgage("mortgageTemp.txt",""," "," "," "," ");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(TextFieldValidate.check(mortgageAmountField,downPaymentField,mortgageTermField,interestRateField,monthField)==0){

                WarningBox.display("Everything filled","Leave the field which want to Calculate Blank");

            }else if(TextFieldValidate.check(mortgageAmountField,downPaymentField,mortgageTermField,interestRateField,monthField)>1){

                WarningBox.display("Lack on Values","Leave Only 1 field Blank");

            }else if(TextFieldValidate.check(mortgageAmountField,downPaymentField,mortgageTermField,interestRateField,monthField)==1 && mortgageAmountField.getText().trim().isEmpty()){
                //calculating Mortgage Amount

                double mortgageTerm = parseDouble(mortgageTermField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double monthPMT = parseDouble(monthField.getText());
                double downPayment = parseDouble(downPaymentField.getText());
                double nOF = 12.0;

                double mortgageAmountOutcome = downPayment + ((nOF * monthPMT * (Math.pow((1 + (interestRate / nOF)), (nOF * mortgageTerm)) - 1)) / (interestRate * Math.pow((1 + (interestRate / nOF)), (nOF * mortgageTerm))));
                double outcome = Double.valueOf(df.format(mortgageAmountOutcome));
                mortgageAmountField.setText(String.valueOf(outcome));

                try {
                    FileWrite.mortgage("mortgage.txt",outcome,downPayment,mortgageTerm,interestRate,monthPMT);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldValidate.check(mortgageAmountField,downPaymentField,mortgageTermField,interestRateField,monthField)==1 && mortgageTermField.getText().trim().isEmpty()){
                //calculating Mortgage Term


                double mortgageAmount = parseDouble(mortgageAmountField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double monthPMT = parseDouble(monthField.getText());
                double downPayment = parseDouble(downPaymentField.getText());
                double nOF = 12.0;

                double mortgageTermOutcome = (Math.log((monthPMT / (monthPMT - ((interestRate/nOF) * (mortgageAmount - downPayment)))))) /  (nOF * Math.log(1 + (interestRate/nOF)));
                double outcome = Double.valueOf(df.format(mortgageTermOutcome));
                mortgageTermField.setText(String.valueOf(outcome));

                try {
                    FileWrite.mortgage("mortgage.txt",mortgageAmount,downPayment,outcome,interestRate,monthPMT);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldValidate.check(mortgageAmountField,downPaymentField,mortgageTermField,interestRateField,monthField)==1 && interestRateField.getText().trim().isEmpty()){
                //Interest Rate Warning Box
                WarningBox.display("Interest Rate cannot be calculated","Please try calculating some other field");
            }else if(TextFieldValidate.check(mortgageAmountField,downPaymentField,mortgageTermField,interestRateField,monthField)==1 && monthField.getText().trim().isEmpty()){
                //calculate monthPMT

                double mortgageTerm = parseDouble(mortgageTermField.getText());
                double mortgageAmount = parseDouble(mortgageAmountField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double downPayment = parseDouble(downPaymentField.getText());
                double nOF = 12.0;

                double mortgageMonthPMTOutcome = ((mortgageAmount - downPayment) * (interestRate / nOF) * Math.pow((1 + (interestRate/nOF)), nOF * mortgageTerm)) / (Math.pow((1 + (interestRate / nOF)), nOF * mortgageTerm) - 1);
                double outcome = Double.valueOf(df.format(mortgageMonthPMTOutcome));
                monthField.setText(String.valueOf(outcome));

                try {
                    FileWrite.mortgage("mortgage.txt",mortgageAmount,downPayment,mortgageTerm,interestRate,outcome);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldValidate.check(mortgageAmountField,downPaymentField,mortgageTermField,interestRateField,monthField)==1 && downPaymentField.getText().trim().isEmpty()){
                //calculate downPayment

                double mortgageTerm = parseDouble(mortgageTermField.getText());
                double mortgageAmount = parseDouble(mortgageAmountField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double monthPMT = parseDouble(monthField.getText());

                double nOF = 12.0;

                double downpaymentOutcome = mortgageAmount - ((nOF * monthPMT * (Math.pow((1 + (interestRate / nOF)), nOF * mortgageTerm) - 1)) / (mortgageTerm * Math.pow((1 + (interestRate / nOF)), nOF * mortgageTerm)));
                double outcome = Double.valueOf(df.format(downpaymentOutcome));
                downPaymentField.setText(String.valueOf(outcome));

                try {
                    FileWrite.mortgage("mortgage.txt",mortgageAmount,outcome,mortgageTerm,interestRate,monthPMT);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }



        });

        resetBtn.setOnAction(e->{
            mortgageAmountField.clear();
            mortgageTermField.clear();
            interestRateField.clear();
            monthField.clear();
            downPaymentField.clear();
        });







        Pane root2 = new Pane();
        root2.getChildren().addAll(
                mortgageAmountText,mortgageTermText,downPaymentText,interestRateText,monthPaymentText,Keyboard.displayKeyboard(130,30,mortgageAmountField,mortgageTermField,interestRateField,monthField,downPaymentField),
                mortgageTermField,downPaymentField,interestRateField,monthField,calculateBtn, mortgageAmountField, resetBtn,TopBar.display(window,0,10)
        );

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(root2);


        keyBoardScene = new Scene(root2,900,700);
        keyBoardScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());
        root2.setStyle("-fx-background-color: #91c09e;");

        window.setScene(keyBoardScene);
        window.show();


        //When the UI close Button is Clicked;
        window.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST,event -> {
            try {
                FileTempoWrite.mortgage("mortgageTemp.txt",mortgageAmountField.getText(),downPaymentField.getText(),mortgageTermField.getText(),interestRateField.getText(),monthField.getText());
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
