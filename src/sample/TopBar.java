package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TopBar {
    public static Pane display(Stage stage, double x, double y){
        Pane topBarPane = new Pane();



        Button backBtn =                createButton("Home",            0,  -10,100,40);
        Button simpleSavingBtn =        createButton("Simple",          100,-10,160,40);
        Button compoundSavingBtn =      createButton("Compound",        260,-10,160,40);
        Button loanBtn =                createButton("Loan",            420,-10,160,40);
        Button mortgageBtn =            createButton("Mortgage",        580,-10,160,40);
        Button historyBtn =            createButton("History",          740,-10,160,40);


        backBtn.setId("backBtn");
        simpleSavingBtn.setId("simpleSavingBtn");
        compoundSavingBtn.setId("compoundSavingBtn");
        loanBtn.setId("loanBtn");
        mortgageBtn.setId("mortgageBtn");
        historyBtn.setId("historyBtn");

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

        loanBtn.setOnAction(event -> {
            stage.close();
            try {
                Loan.display();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        historyBtn.setOnAction(event -> {
            stage.close();
            try {
                History.display();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        mortgageBtn.setOnAction(event -> {
            stage.close();
            try {
                Mortgage.display();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });


        topBarPane.getChildren().addAll(
               backBtn,simpleSavingBtn,compoundSavingBtn,loanBtn,mortgageBtn,historyBtn
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