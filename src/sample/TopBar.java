package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class TopBar {
    public static Pane display(Stage stage, double x, double y){
        Pane topBarPane = new Pane();



        Button backBtn =                createButton("Home",            0, -10,100,40);
        Button simpleSavingBtn =        createButton("Simple",          100,-10,200,40);
        Button compoundSavingBtn =      createButton("Compound",        300,-10,200,40);
        Button loanBtn =                createButton("Loan",            500,-10,200,40);
        Button mortgageBtn =            createButton("Mortgage",        700,-10,200,40);


        backBtn.setId("backBtn");
        simpleSavingBtn.setId("simpleSavingBtn");
        compoundSavingBtn.setId("compoundSavingBtn");
        loanBtn.setId("loanBtn");
        mortgageBtn.setId("mortgageBtn");

        backBtn.setOnAction(event -> {
            stage.close();
            HomePage.display();
        });

        simpleSavingBtn.setOnAction(event -> {
            stage.close();
            try {
                SimpleSaving.display();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        compoundSavingBtn.setOnAction(event -> {
            stage.close();
            try {
                CompoundSaving.display();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });


        topBarPane.getChildren().addAll(
               backBtn,simpleSavingBtn,compoundSavingBtn,loanBtn,mortgageBtn
        );
        topBarPane.setLayoutX(x);
        topBarPane.setLayoutY(y);

        topBarPane.getStylesheets().add(Keyboard.class.getResource("stylesheet.css").toExternalForm());

        return topBarPane;

    }

    public static Button createButton(String ButtonText, double x, double y, double j, double k){
        Button button = new Button(ButtonText);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefSize(j,k);

        return button;
    }
}