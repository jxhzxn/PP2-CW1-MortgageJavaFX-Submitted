package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.io.FileNotFoundException;

public class Keyboard {
    public static Pane displayKeyboard(double x, double y){
        Pane keyboardPane = new Pane();

        TextField keyboardText = new TextField();
        keyboardText.setLayoutX(400);
        keyboardText.setLayoutY(60);
        keyboardText.setPrefHeight(70);
        keyboardText.setPrefWidth(230);
        keyboardText.setId("keyboardText");


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
        Button buttonPOM = createButton("+",560,470,70,70);
        Button buttonEnter = createButton("Enter",400,470,150,70);
        Button buttonC = createButton("C",560,390,70,70);

        button0.setOnAction(event -> {
            String currentVal = keyboardText.getText();
            String btn0Value = button0.getText();
            keyboardText.setText(currentVal+btn0Value);
        });

        button1.setOnAction(event -> {
            String currentVal = keyboardText.getText();
            String btn1Value = button1.getText();
            keyboardText.setText(currentVal+btn1Value);
        });

        button2.setOnAction(event -> {
            String currentVal = keyboardText.getText();
            String btn2Value = button2.getText();
            keyboardText.setText(currentVal+btn2Value);
        });

        button3.setOnAction(event -> {
            String currentVal = keyboardText.getText();
            String btn3Value = button3.getText();
            keyboardText.setText(currentVal+btn3Value);
        });

        button4.setOnAction(event -> {
            String currentVal = keyboardText.getText();
            String btn4Value = button4.getText();
            keyboardText.setText(currentVal+btn4Value);
        });

        button5.setOnAction(event -> {
            String currentVal = keyboardText.getText();
            String btn5Value = button5.getText();
            keyboardText.setText(currentVal+btn5Value);
        });

        button6.setOnAction(event -> {
            String currentVal = keyboardText.getText();
            String btn6Value = button6.getText();
            keyboardText.setText(currentVal+btn6Value);
        });

        button7.setOnAction(event -> {
            String currentVal = keyboardText.getText();
            String btn7Value = button7.getText();
            keyboardText.setText(currentVal+btn7Value);
        });

        button8.setOnAction(event -> {
            String currentVal = keyboardText.getText();
            String btn8Value = button8.getText();
            keyboardText.setText(currentVal+btn8Value);
        });

        button9.setOnAction(event -> {
            String currentVal = keyboardText.getText();
            String btn9Value = button9.getText();
            keyboardText.setText(currentVal+btn9Value);
        });

        buttonPoint.setOnAction(event -> {
            String currentVal = keyboardText.getText();
            String btnPointValue = buttonPoint.getText();
            keyboardText.setText(currentVal+btnPointValue);
        });

        buttonC.setOnAction(event -> {
            keyboardText.clear();
        });

        keyboardPane.getChildren().addAll(
                button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,
                buttonC,buttonPOM,buttonPoint,buttonEnter,keyboardText
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

}
