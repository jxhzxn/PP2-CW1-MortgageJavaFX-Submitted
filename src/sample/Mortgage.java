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
import java.util.List;

import static java.lang.Double.parseDouble;

public class Mortgage{

    public static void display() throws FileNotFoundException {
        Stage window = new Stage();
        Scene keyBoardScene;
        window.setTitle("Mortgage");

        Text mortgageAmountText = new Text("Mortgage Amount");
        Text mortgageTermText = new Text("Mortgage Term");
        Text interestRateText = new Text("Interest Rate");
        Text monthPaymentText = new Text("Month Payment");

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setId("keyboardButton");
        calculateBtn.setLayoutX(60);
        calculateBtn.setLayoutY(500);

        Button resetBtn = new Button("Reset");
        resetBtn.setId("keyboardButton");
        resetBtn.setLayoutX(250);
        resetBtn.setLayoutY(500);

        mortgageAmountText.setId("fdText");
        mortgageTermText.setId("fdText");
        interestRateText.setId("fdText");
        monthPaymentText.setId("fdText");

        mortgageAmountText.setLayoutX(60);
        mortgageAmountText.setLayoutY(220);

        mortgageTermText.setLayoutX(60);
        mortgageTermText.setLayoutY(290);

        interestRateText.setLayoutX(60);
        interestRateText.setLayoutY(360);

        monthPaymentText.setLayoutX(60);
        monthPaymentText.setLayoutY(430);


        TextField mortgageAmountField =     createTextField(300,180,150,60,"futureValueField");
        TextField mortgageTermField =       createTextField(300,250,150,60,"presentValueField");
        TextField interestRateField =       createTextField(300,320,150,60,"interestRateField");
        TextField monthField =              createTextField(300,390,150,60,"yearsField");


        List<String> readList = FileReadTemp.read("./mortgageTemp.txt");
        mortgageAmountField.setText(readList.get(0));
        mortgageTermField.setText(readList.get(1));
        interestRateField.setText(readList.get(2));
        monthField.setText(readList.get(3));


        calculateBtn.setOnAction(event -> {

            try {
                FileTempoWrite.simpleSaving("mortgageTemp.txt"," "," "," "," ");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(TextFieldValidate.check(mortgageAmountField,mortgageTermField,interestRateField,monthField)==0){

                WarningBox.display("Everything filled","Leave the field which want to Calculate Blank");

            }else if(TextFieldValidate.check(mortgageAmountField,mortgageTermField,interestRateField,monthField)>1){

                WarningBox.display("Lack on Values","Leave Only 1 field Blank");

            }else if(TextFieldValidate.check(mortgageAmountField,mortgageTermField,interestRateField,monthField)==1 && mortgageAmountField.getText().trim().isEmpty()){
                //calculate future value

                double presentValue = parseDouble(mortgageTermField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double years = parseDouble(monthField.getText());
                double nOF = 12.0;

                double futureValeOutcome = presentValue*Math.pow(((1+(interestRate/nOF))),(nOF*years));
                mortgageAmountField.setText(String.valueOf(futureValeOutcome));

                try {
                    FileWrite.simpleSaving("mortgage.txt",futureValeOutcome,presentValue,interestRate,years);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldValidate.check(mortgageAmountField,mortgageTermField,interestRateField,monthField)==1 && mortgageTermField.getText().trim().isEmpty()){
                //calculate present value

                double futureValue = parseDouble(mortgageAmountField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double years = parseDouble(monthField.getText());
                double nOF = 12.0;

                double presentValueOutcome = futureValue/Math.pow(1+(interestRate/nOF),(nOF*years));
                mortgageTermField.setText(String.valueOf(presentValueOutcome));

                try {
                    FileWrite.simpleSaving("mortgage.txt",futureValue,presentValueOutcome,interestRate,years);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(TextFieldValidate.check(mortgageAmountField,mortgageTermField,interestRateField,monthField)==1 && interestRateField.getText().trim().isEmpty()){
                WarningBox.display("Interest Rate cannot be calculated","Please try calculating some other field");
            }else if(TextFieldValidate.check(mortgageAmountField,mortgageTermField,interestRateField,monthField)==1 && monthField.getText().trim().isEmpty()){
                //calculate years

                double futureValue = parseDouble(mortgageAmountField.getText());
                double presentValue = parseDouble(mortgageTermField.getText());
                double interestRate = parseDouble(interestRateField.getText())/100;
                double nOF = 12.0;

                double yearsOutcome = (Math.log(futureValue/presentValue))/nOF*(Math.log(1+(interestRate/nOF)));
                monthField.setText(String.valueOf(yearsOutcome));

                try {
                    FileWrite.simpleSaving("mortgage.txt",futureValue,presentValue,interestRate,yearsOutcome);
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
        });







        Pane root2 = new Pane();
        root2.getChildren().addAll(
                mortgageAmountText,mortgageTermText,interestRateText,monthPaymentText,Keyboard.displayKeyboard(130,40,mortgageAmountField,mortgageTermField,interestRateField,monthField),
                mortgageTermField,interestRateField,monthField,calculateBtn, mortgageAmountField, resetBtn,TopBar.display(window,0,10)
        );

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(root2);


        keyBoardScene = new Scene(root2,900,700);
        keyBoardScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());
        root2.setStyle("-fx-background-color: #eebb4d;");

        window.setScene(keyBoardScene);
        window.show();


        //When the UI close Button is Clicked;
        window.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST,event -> {
            try {
                FileTempoWrite.simpleSaving("mortgageTemp.txt",mortgageAmountField.getText(),mortgageTermField.getText(),interestRateField.getText(),monthField.getText());
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
