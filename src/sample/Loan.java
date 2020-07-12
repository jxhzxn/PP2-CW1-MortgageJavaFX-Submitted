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

public class Loan {

    public static void display() throws FileNotFoundException {
        Stage window = new Stage();
        Scene keyBoardScene;
        window.setTitle("Loan");

        DecimalFormat df = new DecimalFormat("#.##");

        //creating the texts
        Text loanAmountText = new Text("Loan Amount");
        Text monthlyPaymentText = new Text("Monthly Payment");
        Text interestRateText = new Text("Interest Rate");
        Text monthText = new Text("Loan Month Terms");

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setId("keyboardButton");
        calculateBtn.setLayoutX(90);
        calculateBtn.setLayoutY(570);

        Button resetBtn = new Button("Reset");
        resetBtn.setId("keyboardButton");
        resetBtn.setLayoutX(320);
        resetBtn.setLayoutY(570);


        loanAmountText.setId("fdText");
        monthlyPaymentText.setId("fdText");
        interestRateText.setId("fdText");
        monthText.setId("fdText");

        loanAmountText.setLayoutX(50);
        loanAmountText.setLayoutY(220);

        monthlyPaymentText.setLayoutX(50);
        monthlyPaymentText.setLayoutY(290);

        interestRateText.setLayoutX(50);
        interestRateText.setLayoutY(360);

        monthText.setLayoutX(50);
        monthText.setLayoutY(430);



        //creating the textfields
        TextField loanAmountField =         createTextField(300,180,150,60,"futureValueField");
        TextField monthlyPaymentField =     createTextField(300,250,150,60,"presentValueField");
        TextField interestRateField =       createTextField(300,320,150,60,"interestRateField");
        TextField monthField =              createTextField(300,390,150,60,"yearsField");

        //setting the temporary input field data
        List<String> readList = FileReadTemp.read("./loanTemp.txt");
        loanAmountField.setText(readList.get(0));
        monthlyPaymentField.setText(readList.get(1));
        interestRateField.setText(readList.get(2));
        monthField.setText(readList.get(3));

        Label headText = new Label("Loan");
        headText.setLayoutX(10);
        headText.setLayoutY(50);
        headText.setId("headText");


        calculateBtn.setOnAction(event -> {

            try {
                FileTempoWrite.simpleSaving("loanTemp.txt"," "," "," "," ");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(TextFieldValidate.check(loanAmountField,monthlyPaymentField,interestRateField,monthField)==0){

                WarningBox.display("Everything filled","Leave the field which want to Calculate Blank");

            }else if(TextFieldValidate.check(loanAmountField,monthlyPaymentField,interestRateField,monthField)>1){

                WarningBox.display("Lack on Values","Leave Only 1 field Blank");

            }else if(TextFieldValidate.check(loanAmountField,monthlyPaymentField,interestRateField,monthField)==1 && loanAmountField.getText().trim().isEmpty()){
                //calculate loan Amount

                double monthlyPayment = parseDouble(monthlyPaymentField.getText());
                double interestRate = (parseDouble(interestRateField.getText())/12)/100;
                double month = parseDouble(monthField.getText());

                double loanAmountOutcome = ((monthlyPayment/interestRate)*(1-(1/(Math.pow((1+interestRate),(month))))));
                double outcome = Double.valueOf(df.format(loanAmountOutcome));
                loanAmountField.setText(String.valueOf(outcome));

                try {
                    FileWrite.loan("loan.txt",outcome,monthlyPayment,interestRate,month);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldValidate.check(loanAmountField,monthlyPaymentField,interestRateField,monthField)==1 && monthlyPaymentField.getText().trim().isEmpty()){
                //calculate monthly payment

                double loanAmount = parseDouble(loanAmountField.getText());
                double interestRate = (parseDouble(interestRateField.getText())/12)/100;
                double month = parseDouble(monthField.getText());

                double monthlyPaymentOutcome = (loanAmount * interestRate) / (1 - (1 / Math.pow((1 + interestRate), month)));
                double outcome = Double.valueOf(df.format(monthlyPaymentOutcome));
                monthlyPaymentField.setText(String.valueOf(outcome));

                try {
                    FileWrite.loan("loan.txt",loanAmount,outcome,interestRate,month);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldValidate.check(loanAmountField,monthlyPaymentField,interestRateField,monthField)==1 && interestRateField.getText().trim().isEmpty()){
                //calculate interestRateField
                WarningBox.display("Interest Rate cannot be calculated","Please try calculating some other field");
            }else if(TextFieldValidate.check(loanAmountField,monthlyPaymentField,interestRateField,monthField)==1 && monthField.getText().trim().isEmpty()){
                //calculate month

                double monthlyPayment = parseDouble(monthlyPaymentField.getText());
                double loanAmount = parseDouble(loanAmountField.getText());
                double interestRate = (parseDouble(interestRateField.getText())/12)/100;

                double monthOutcome = ((Math.log((monthlyPayment/interestRate)/((monthlyPayment/interestRate)-loanAmount)))/(Math.log(1+interestRate)));
                double outcome = Double.valueOf(df.format(monthOutcome));
                monthField.setText(String.valueOf(outcome));

                try {
                    FileWrite.loan("loan.txt",loanAmount,monthlyPayment,interestRate,outcome);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }



        });

        resetBtn.setOnAction(e->{
            loanAmountField.clear();
            monthlyPaymentField.clear();
            interestRateField.clear();
            monthField.clear();
        });


        Pane root2 = new Pane();
        root2.getChildren().addAll(
                loanAmountText,monthlyPaymentText,interestRateText,monthText,Keyboard.displayKeyboard(130,30,loanAmountField,monthlyPaymentField,interestRateField,monthField),
                monthlyPaymentField,interestRateField,monthField,calculateBtn, loanAmountField, resetBtn,TopBar.display(window,0,10),headText
        );


        keyBoardScene = new Scene(root2,900,700);
        keyBoardScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());
        root2.setStyle("-fx-background-color: #e8df9c;");

        window.setScene(keyBoardScene);
        window.show();


        //When the UI close Button is Clicked;
        window.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST,event -> {
            try {
                FileTempoWrite.loan("loanTemp.txt",loanAmountField.getText(),monthlyPaymentField.getText(),interestRateField.getText(),monthField.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    //method to create the textfields
    private static TextField createTextField(double x, double y, double j, double k,String id){
        TextField textField = new TextField();
        textField.setLayoutX(x);
        textField.setLayoutY(y);
        textField.setId(id);
        textField.setPrefSize(j,k);

        return textField;
    }

}
