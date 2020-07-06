package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

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

        //Setting the ID of the Buttons
        compoundSavingBtn.setId("homeBtn");
        simpleSavingBtn.setId("homeBtn");
        loanBtn.setId("homeBtn");
        mortgageBtn.setId("homeBtn");

        simpleSavingBtn.setPrefSize(330,70);
        simpleSavingBtn.setLayoutX(500);
        simpleSavingBtn.setLayoutY(160);

        compoundSavingBtn.setPrefSize(330,70);
        compoundSavingBtn.setLayoutX(500);
        compoundSavingBtn.setLayoutY(260);



        loanBtn.setPrefSize(330,70);
        loanBtn.setLayoutX(500);
        loanBtn.setLayoutY(360);

        mortgageBtn.setPrefSize(330,70);
        mortgageBtn.setLayoutX(500);
        mortgageBtn.setLayoutY(460);

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
            Loan.display();
        });

        mortgageBtn.setOnAction(e -> {
            window.close();
            Loan.display();
        });

        Pane homePageRoot = new Pane();
        homePageRoot.getChildren().addAll(compoundSavingBtn,simpleSavingBtn,loanBtn,mortgageBtn);


        homePageScene = new Scene(homePageRoot,900,700);
        homePageScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());
        homePageRoot.setStyle("-fx-background-color: #f6cd61;");
        window.setScene(homePageScene);
        window.show();
    }

}