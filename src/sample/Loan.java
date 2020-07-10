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

public class Loan {

    public static void display() throws FileNotFoundException {
        Stage window = new Stage();
        Scene keyBoardScene;
        window.setTitle("Loan");



        Text loanAmountText = new Text("Loan Amount");
        Text monthlyPaymentText = new Text("Monthly Payment");
        Text interestRateText = new Text("Interest Rate");
        Text monthText = new Text("Loan Month Terms");

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setId("keyboardButton");
        calculateBtn.setLayoutX(60);
        calculateBtn.setLayoutY(500);

        Button resetBtn = new Button("Reset");
        resetBtn.setId("keyboardButton");
        resetBtn.setLayoutX(250);
        resetBtn.setLayoutY(500);


        loanAmountText.setId("fdText");
        monthlyPaymentText.setId("fdText");
        interestRateText.setId("fdText");
        monthText.setId("fdText");

        loanAmountText.setLayoutX(60);
        loanAmountText.setLayoutY(220);

        monthlyPaymentText.setLayoutX(60);
        monthlyPaymentText.setLayoutY(290);

        interestRateText.setLayoutX(60);
        interestRateText.setLayoutY(360);

        monthText.setLayoutX(60);
        monthText.setLayoutY(430);



//        TextField futureValueField =     createTextField(300,180,120,60,"futureValueField");
        TextField loanAmountField = createTextField(300,180,120,60,"futureValueField");
        TextField monthlyPaymentField =    createTextField(300,250,120,60,"presentValueField");
        TextField interestRateField =   createTextField(300,320,120,60,"interestRateField");
        TextField monthField =          createTextField(300,390,120,60,"yearsField");

//        installListener(futureValueField,presentValueField,interestRateField,yearsField);

//        File readList = new File("simpleSavingTemp.txt");
//        if(readFile.isDirectory()){



        List<String> readList = FileReadTemp.read("./loanTemp.txt");
        loanAmountField.setText(readList.get(0));
        monthlyPaymentField.setText(readList.get(1));
        interestRateField.setText(readList.get(2));
        monthField.setText(readList.get(3));



//        try {
//            FileTempoWrite.simpleSaving("simpleSavingTemp.txt","","","","");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        }else{
//            System.out.print("file isn't there");
//        }











        calculateBtn.setOnAction(event -> {

//                   try {
//                FileTempoWrite.write("simpleSaving.txt","","","","");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            try {
                FileTempoWrite.simpleSaving("loanTemp.txt"," "," "," "," ");
            } catch (IOException e) {
                e.printStackTrace();
            }


//            window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));


            if(TextFieldValidate.check(loanAmountField,monthlyPaymentField,interestRateField,monthField)==0){

                WarningBox.display("Everything filled","Leave the field which want to Calculate Blank");

            }else if(TextFieldValidate.check(loanAmountField,monthlyPaymentField,interestRateField,monthField)>1){

                WarningBox.display("Lack on Values","Leave Only 1 field Blank");

            }else if(TextFieldValidate.check(loanAmountField,monthlyPaymentField,interestRateField,monthField)==1 && loanAmountField.getText().trim().isEmpty()){
                //calculate loan Amount

                double monthlyPayment = parseDouble(monthlyPaymentField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double month = parseDouble(monthField.getText());

                double loanAmountOutcome = ((monthlyPayment/interestRate)*(1-(1/(Math.pow((1+interestRate),(month))))));
                loanAmountField.setText(String.valueOf(loanAmountOutcome));

                try {
                    FileWrite.loan("loan.txt",loanAmountOutcome,monthlyPayment,interestRate,month);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldValidate.check(loanAmountField,monthlyPaymentField,interestRateField,monthField)==1 && monthlyPaymentField.getText().trim().isEmpty()){
                //calculate monthly payment

                double loanAmount = parseDouble(loanAmountField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double month = parseDouble(monthField.getText());

                double monthlyPaymentOutcome = ((loanAmount*interestRate)/(1-(1/(Math.pow((1+interestRate),(month))))));
                monthlyPaymentField.setText(String.valueOf(monthlyPaymentOutcome));

                try {
                    FileWrite.loan("loan.txt",loanAmount,monthlyPaymentOutcome,interestRate,month);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldValidate.check(loanAmountField,monthlyPaymentField,interestRateField,monthField)==1 && interestRateField.getText().trim().isEmpty()){
                //calculate interestRateField
                //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Still NO:::::::::::::::::::::::::::::::::::::://
                double monthlyPayment = parseDouble(monthlyPaymentField.getText());
                double loanAmount = parseDouble(loanAmountField.getText());
                double month = parseDouble(monthField.getText());

                try {
                    FileWrite.loan("loan.txt",0.0,0.0,0.0,0.0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Still NO:::::::::::::::::::::::::::::::::::::://
            }else if(TextFieldValidate.check(loanAmountField,monthlyPaymentField,interestRateField,monthField)==1 && monthField.getText().trim().isEmpty()){
                //calculate month

                double monthlyPayment = parseDouble(monthlyPaymentField.getText());
                double loanAmount = parseDouble(loanAmountField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;

                double monthOutcome = ((Math.log((monthlyPayment/interestRate)/((monthlyPayment/interestRate)-loanAmount)))/(Math.log(1+interestRate)));
                monthField.setText(String.valueOf(monthOutcome));

                try {
                    FileWrite.loan("loan.txt",loanAmount,monthlyPayment,interestRate,monthOutcome);
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

        activeCheck(loanAmountField,monthlyPaymentField,interestRateField,monthField);



//        Button btnBack = new Button("Back");
//        btnBack.setId("backBtn");
//        btnBack.setLayoutX(10);
//        btnBack.setLayoutY(10);

//        btnBack.setOnAction(e -> {
//            window.close();
//            HomePage.display();
//        });

        Pane root2 = new Pane();
        root2.getChildren().addAll(
                loanAmountText,monthlyPaymentText,interestRateText,monthText,Keyboard.displayKeyboard(130,40,loanAmountField,monthlyPaymentField,interestRateField,monthField),
                monthlyPaymentField,interestRateField,monthField,calculateBtn, loanAmountField, resetBtn,TopBar.display(window,0,10)
        );


        keyBoardScene = new Scene(root2,900,700);
        keyBoardScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());
        root2.setStyle("-fx-background-color: #01a9b4;");

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


    private static int checkAll(TextField... textFields){
        int count = 0;
        for(TextField textField : textFields){
            if (textField.getText().trim().isEmpty()){
                count++;
            }
        }
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
