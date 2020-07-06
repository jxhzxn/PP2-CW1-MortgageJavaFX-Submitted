package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Saving{

    public static void display() throws FileNotFoundException {
        Stage window = new Stage();
        Scene keyBoardScene;
        window.setTitle("Simple Savings");

        Text futureValueText = new Text("Future Value");
        Text presentValueText = new Text("Present Value");
        Text interestRateText = new Text("Interest Rate");
        Text yearsText = new Text("Time in Years");

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setId("keyboardButton");
        calculateBtn.setLayoutX(60);
        calculateBtn.setLayoutY(500);


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



//        TextField futureValueField =     createTextField(300,180,120,60,"futureValueField");
        TextField futureValueField = createTextField(300,180,120,60,"futureValueField");
        TextField presentValueField =    createTextField(300,250,120,60,"presentValueField");
        TextField interestRateField =   createTextField(300,320,120,60,"interestRateField");
        TextField yearsField =          createTextField(300,390,120,60,"yearsField");

//        installListener(futureValueField,presentValueField,interestRateField,yearsField);

        calculateBtn.setOnAction(event -> {
            checkAll(futureValueField,presentValueField,interestRateField,yearsField);
            if(checkAll(futureValueField,presentValueField,interestRateField,yearsField)>1){
                WarningBox.display("Lack on Values","Leave Only 1 field Blank");
            }else if(checkAll(futureValueField,presentValueField,interestRateField,yearsField)==1 && futureValueField.getText().trim().isEmpty()){
                //calculate future value
                System.out.println("calculate future value");
            }else if(checkAll(futureValueField,presentValueField,interestRateField,yearsField)==1 && presentValueField.getText().trim().isEmpty()){
                //calculate present value
                System.out.println("calculate present value");
            }else if(checkAll(futureValueField,presentValueField,interestRateField,yearsField)==1 && interestRateField.getText().trim().isEmpty()){
                //calculate interestRateField
                System.out.println("calculate Interest");
            }else if(checkAll(futureValueField,presentValueField,interestRateField,yearsField)==1 && yearsField.getText().trim().isEmpty()){
                //calculate years
                System.out.println("calculate Years");
            }
        });

        activeCheck(futureValueField,presentValueField,interestRateField,yearsField);



        Button btnBack = new Button("Back");
        btnBack.setId("backBtn");
        btnBack.setLayoutX(10);
        btnBack.setLayoutY(10);

        btnBack.setOnAction(e -> {
            window.close();
            HomePage.display();
        });

        Pane root2 = new Pane();
        root2.getChildren().addAll(
               futureValueText,presentValueText,interestRateText,yearsText,btnBack,Keyboard.displayKeyboard(100,20),
                presentValueField,interestRateField,yearsField,calculateBtn, futureValueField
        );

        keyBoardScene = new Scene(root2,900,700);
        keyBoardScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());
        root2.setStyle("-fx-background-color: #e1ffc2;");

        window.setScene(keyBoardScene);
        window.show();



    }

    private static int checkAll(TextField... textFields){
        int count = 0;
        for(TextField textField : textFields){
                if (textField.getText().trim().isEmpty()){
                    count++;
                }
        }
        System.out.println(count);
        return count;
    }

    private static void activeCheck(TextField... textFields){
        for (TextField textField : textFields) {
            textField.focusedProperty().addListener((observableValue, oldValue, newValue) -> {
                System.out.println(textField.getId()+" is Active");
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
                    System.out.println("Selected Text: " + selectedTextField.getText());
                }
            });
        }
    }






}
