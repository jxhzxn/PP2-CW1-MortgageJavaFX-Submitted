package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

import static sample.Keyboard.displayKeyboard;

public class FixedDeposit{

    public static void display() throws FileNotFoundException {
        Stage window = new Stage();
        Scene keyBoardScene;
        window.setTitle("Fixed Deposit");

        Text capitalText = new Text("Capital");
        Text rateText = new Text("Rate");
        Text periodText = new Text("Period");
        Text fvText = new Text("FV");

        capitalText.setId("fdText");
        rateText.setId("fdText");
        periodText.setId("fdText");
        fvText.setId("fdText");

        capitalText.setLayoutX(60);
        capitalText.setLayoutY(200);

        rateText.setLayoutX(60);
        rateText.setLayoutY(250);

        periodText.setLayoutX(60);
        periodText.setLayoutY(300);

        fvText.setLayoutX(60);
        fvText.setLayoutY(350);

        Button btnBack = new Button("Back");

        btnBack.setOnAction(e -> {
            window.close();
            HomePage.display();
        });

        Pane root2 = new Pane();
        root2.getChildren().addAll(capitalText,rateText,periodText,fvText,btnBack,Keyboard.displayKeyboard(100,20));

        keyBoardScene = new Scene(root2,900,700);
        keyBoardScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());

        window.setScene(keyBoardScene);
        window.show();
    }

}


