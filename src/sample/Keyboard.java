package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Keyboard {
    public static Pane displayKeyboard(double x, double y, TextField... textFields){
        Pane keyboardPane = new Pane();

        TextField textfield = new TextField();
        textfield.setLayoutX(400);
        textfield.setLayoutY(60);
        textfield.setPrefHeight(70);
        textfield.setPrefWidth(230);
        textfield.setId("keyboardText");


        Button button0 = createButton("0",480,390,70,70);
        Button button1 = createButton("1",400,310,70,70);
        Button button2 = createButton("2",480,310,70,70);
        Button button3 = createButton("3",560,310,70,70);
        Button button4 = createButton("4",400,230,70,70);
        Button button5 = createButton("5",480,230,70,70);
        Button button6 = createButton("6",560,230,70,70);
        Button button7 = createButton("7",400,150,70,70);
        Button button8 = createButton("8",480,150,70,70);
        Button button9 = createButton("9",560,150,70,70);
        Button buttonPoint = createButton(".",400,390,70,70);
        Button buttonPOM = createButton("+/-",640,310,80,150);

        Button buttonC = createButton("C",560,390,70,70);
        Button backSpace = createButton("<-",640,150,80,150);

        backSpace.setStyle("-fx-background-color: #e8505b;");
        buttonC.setStyle("-fx-background-color: #e8505b;");


        for (TextField textField : textFields) {
            textField.focusedProperty().addListener((observableValue, oldValue, newValue) -> {
                TextField selectedTextField = null;
                AtomicReference<String> checkPoint = new AtomicReference<>("false");
                if (newValue) {

                    selectedTextField = textField;

                    TextField finalSelectedTextField = selectedTextField;
                    button0.setOnAction(event -> {
                        String currentVal = finalSelectedTextField.getText();
                        String btn0Value = button0.getText();
                        finalSelectedTextField.setText(currentVal+btn0Value);
                    });

                    TextField finalSelectedTextField1 = selectedTextField;
                    button1.setOnAction(event -> {
                        String currentVal = finalSelectedTextField1.getText();
                        String btn1Value = button1.getText();
                        finalSelectedTextField1.setText(currentVal+btn1Value);
                    });

                    TextField finalSelectedTextField2 = selectedTextField;
                    button2.setOnAction(event -> {
                        String currentVal = finalSelectedTextField2.getText();
                        String btn2Value = button2.getText();
                        finalSelectedTextField2.setText(currentVal+btn2Value);
                    });

                    TextField finalSelectedTextField3 = selectedTextField;
                    button3.setOnAction(event -> {
                        String currentVal = finalSelectedTextField3.getText();
                        String btn3Value = button3.getText();
                        finalSelectedTextField3.setText(currentVal+btn3Value);
                    });

                    TextField finalSelectedTextField4 = selectedTextField;
                    button4.setOnAction(event -> {
                        String currentVal = finalSelectedTextField4.getText();
                        String btn4Value = button4.getText();
                        finalSelectedTextField4.setText(currentVal+btn4Value);
                    });

                    TextField finalSelectedTextField5 = selectedTextField;
                    button5.setOnAction(event -> {
                        String currentVal = finalSelectedTextField5.getText();
                        String btn5Value = button5.getText();
                        finalSelectedTextField5.setText(currentVal+btn5Value);
                    });

                    TextField finalSelectedTextField6 = selectedTextField;
                    button6.setOnAction(event -> {
                        String currentVal = finalSelectedTextField6.getText();
                        String btn6Value = button6.getText();
                        finalSelectedTextField6.setText(currentVal+btn6Value);
                    });

                    TextField finalSelectedTextField7 = selectedTextField;
                    button7.setOnAction(event -> {
                        String currentVal = finalSelectedTextField7.getText();
                        String btn7Value = button7.getText();
                        finalSelectedTextField7.setText(currentVal+btn7Value);
                    });

                    TextField finalSelectedTextField8 = selectedTextField;
                    button8.setOnAction(event -> {
                        String currentVal = finalSelectedTextField8.getText();
                        String btn8Value = button8.getText();
                        finalSelectedTextField8.setText(currentVal+btn8Value);
                    });

                    TextField finalSelectedTextField9 = selectedTextField;
                    button9.setOnAction(event -> {
                        String currentVal = finalSelectedTextField9.getText();
                        String btn9Value = button9.getText();
                        finalSelectedTextField9.setText(currentVal+btn9Value);
                        System.out.println(checkPoint.get());
                    });

                    //Point Button
                    TextField finalSelectedTextField10 = selectedTextField;
                    buttonPoint.setOnAction(event -> {
                        if(checkPoint.get() == "true"){

                        }else{
                            String currentVal = finalSelectedTextField10.getText();
                            String btnPointValue = buttonPoint.getText();
                            finalSelectedTextField10.setText(currentVal+btnPointValue);
                            checkPoint.set("true");
                        }

                    });

                    TextField finalSelectedTextField11 = selectedTextField;
                    buttonC.setOnAction(event -> {
                        finalSelectedTextField11.clear();
                    });

                    TextField finalSelectedTextField12 = selectedTextField;
                    backSpace.setOnAction(event -> {
                        String currentVal = finalSelectedTextField12.getText();
                        finalSelectedTextField12.setText(finalSelectedTextField12.getText().substring(0, finalSelectedTextField12.getLength() - 1));
                    });

                }
            });
        }



        keyboardPane.getChildren().addAll(
                button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,backSpace,
                buttonC,buttonPOM,buttonPoint
        );
        keyboardPane.setLayoutX(x);
        keyboardPane.setLayoutY(y);

        keyboardPane.getStylesheets().add(Keyboard.class.getResource("stylesheet.css").toExternalForm());

        return keyboardPane;

    }

    private static Button createButton(String ButtonText, double x, double y, double j, double k){
        Button button = new Button(ButtonText);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setId("keyboardButton");
        button.setPrefSize(j,k);

        return button;
    }

    public static boolean test(String currentVal){
        boolean out;
        for(int i=0; i<currentVal.length()-1; i++){
            List<Character> readList = new ArrayList<>();
            readList.add(currentVal.charAt(i));

            for (int x=0; x<readList.size()-1; x++){
                if (readList.get(i)=='.'){
                    out = true;
                }else{
                    out = false;
                }
            }
        }
        return true;
    }
}