package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Keyboard{

    public static void display(){
        Stage window = new Stage();
        Scene keyBoardScene;

        Button btn0 = new Button("0");
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btnPoint = new Button(".");
        Button btnEnter = new Button("Enter");
        Button btnC = new Button("C");


        btn0.setPrefSize(50,50);
        btn1.setPrefSize(50,50);
        btn2.setPrefSize(50,50);
        btn3.setPrefSize(50,50);
        btn4.setPrefSize(50,50);
        btn5.setPrefSize(50,50);
        btn6.setPrefSize(50,50);
        btn7.setPrefSize(50,50);
        btn8.setPrefSize(50,50);
        btn9.setPrefSize(50,50);
        btnPoint.setPrefSize(50,50);
        btnEnter.setPrefSize(170,50);
        btnC.setPrefSize(50,50);


        btn9.setLayoutX(520);
        btn9.setLayoutY(150);

        btn8.setLayoutX(460);
        btn8.setLayoutY(150);

        btn7.setLayoutX(400);
        btn7.setLayoutY(150);

        btn6.setLayoutX(520);
        btn6.setLayoutY(210);

        btn5.setLayoutX(460);
        btn5.setLayoutY(210);

        btn4.setLayoutX(400);
        btn4.setLayoutY(210);

        btn3.setLayoutX(520);
        btn3.setLayoutY(270);

        btn2.setLayoutX(460);
        btn2.setLayoutY(270);

        btn1.setLayoutX(400);
        btn1.setLayoutY(270);

        btnC.setLayoutX(520);
        btnC.setLayoutY(330);

        btn0.setLayoutX(460);
        btn0.setLayoutY(330);

        btnPoint.setLayoutX(400);
        btnPoint.setLayoutY(330);

        btnEnter.setLayoutX(400);
        btnEnter.setLayoutY(390);

        btnEnter.setOnAction(e -> {
            window.close();
            HomePage.display();
        });







        Pane root2 = new Pane();
        root2.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnEnter,btn0,btnPoint,btnC);

        keyBoardScene = new Scene(root2,900,900);

        window.setScene(keyBoardScene);
        window.show();
    }





}


