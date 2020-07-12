package sample;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.io.IOException;

public class Help{

    public static void display() throws IOException {
        Stage helpWindow = new Stage();
        Scene HistoryScene;
        helpWindow.setTitle("History");

        //creating the pane
        Pane root2 = new Pane();

        Label headText = new Label("Help");
        headText.setLayoutX(10);
        headText.setLayoutY(50);
        headText.setId("headText");

        Label help1 = new Label("1. Simple Saving, Compound Saving, Loan and Mortgage\n can be Calculated");
        Label help2 = new Label("2. Leave the TextField empty which you want to calculate");
        Label help3 = new Label("3. Numbers can be input via the Onscreen Keyboard");
        Label help4 = new Label("4. Even if the app get closed by mistakenly, the input fields \n will be re populate when you relaunch the app");
        Label help5 = new Label("5. The full history of your calculations can be viewed \nin the 'History' section");

        help1.setId("helpText");
        help2.setId("helpText");
        help3.setId("helpText");
        help4.setId("helpText");
        help5.setId("helpText");

        help1.setLayoutX(40);
        help2.setLayoutX(40);
        help3.setLayoutX(40);
        help4.setLayoutX(40);
        help5.setLayoutX(40);

        help1.setLayoutY(200);
        help2.setLayoutY(300);
        help3.setLayoutY(400);
        help4.setLayoutY(500);
        help5.setLayoutY(600);


        root2.getChildren().addAll(TopBar.display(helpWindow,0,10),headText,help1,help2,help3,help4,help5);

        HistoryScene = new Scene(root2,900,700);
        HistoryScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());
        root2.setStyle("-fx-background-color: #b83b5e;");

        helpWindow.setScene(HistoryScene);
        helpWindow.show();
    }

}

