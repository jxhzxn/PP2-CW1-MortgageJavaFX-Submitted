package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HomePage{

    public static void display(){
        Stage window = new Stage();
        Scene homePageScene;
        window.setTitle("Financial Calculator");

        //HomePageButtons
        Button simpleSavingBtn = new Button("Simple Savings");
        Button compoundSavingBtn = new Button("Compound Savings");
        Button loanBtn = new Button("Loans");
        Button mortgageBtn = new Button("Mortgage");
        Button helpBtn = new Button("Help");

        Label headLbl = new Label("Financial");
        Label subHeadLbl = new Label("Calculator");

        //Setting the ID of the Buttons
        compoundSavingBtn.setId("homeBtn");
        simpleSavingBtn.setId("homeBtn");
        loanBtn.setId("homeBtn");
        mortgageBtn.setId("homeBtn");
        helpBtn.setId("helpBtn");

        simpleSavingBtn.setPrefSize(330,70);
        compoundSavingBtn.setPrefSize(330,70);
        loanBtn.setPrefSize(330,70);
        mortgageBtn.setPrefSize(330,70);

        simpleSavingBtn.setLayoutX(450);
        compoundSavingBtn.setLayoutX(450);
        loanBtn.setLayoutX(450);
        mortgageBtn.setLayoutX(450);

        simpleSavingBtn.setLayoutY(220);
        compoundSavingBtn.setLayoutY(320);
        loanBtn.setLayoutY(420);
        mortgageBtn.setLayoutY(520);



        helpBtn.setPrefSize(100,50);
        helpBtn.setLayoutX(70);
        helpBtn.setLayoutY(535);

        headLbl.setLayoutX(60);
        headLbl.setLayoutY(50);
        subHeadLbl.setLayoutX(60);
        subHeadLbl.setLayoutY(120);
        headLbl.setId("heading");
        subHeadLbl.setId("subHeading");
        helpBtn.setId("helpBtn");


        //functions for each buttons
        compoundSavingBtn.setOnAction(e -> {
            window.close();
            try {
                CompoundSaving.display();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        simpleSavingBtn.setOnAction(e -> {
            window.close();
            try {
                SimpleSaving.display();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        loanBtn.setOnAction(e -> {
            window.close();
            try {
                Loan.display();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        mortgageBtn.setOnAction(e -> {
            window.close();
            try {
                Mortgage.display();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        helpBtn.setOnAction(event -> {
            window.close();
            try {
                Help.display();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });



        Pane homePageRoot = new Pane();
        homePageRoot.getChildren().addAll(compoundSavingBtn,simpleSavingBtn,loanBtn,mortgageBtn,helpBtn,headLbl,subHeadLbl);

        homePageScene = new Scene(homePageRoot,900,700);
        homePageScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());
        homePageRoot.setStyle("-fx-background-color: #2a7b9b;");
        window.setScene(homePageScene);
        window.show();
    }

}