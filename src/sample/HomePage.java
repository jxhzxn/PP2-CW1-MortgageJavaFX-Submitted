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

import java.io.FileNotFoundException;

public class HomePage{

    public static void display(){
        Stage window = new Stage();
        Scene homePageScene;
        window.setTitle("Welcome to the Calculator");

        //HomePageButtons
        Button fixedDepositBtn = new Button("Fixed Deposit");
        Button savingsBtn = new Button("Savings");
        Button loanBtn = new Button("Loan");
        Button mortgageBtn = new Button("Mortgage");

        //Setting the ID of the Buttons
        fixedDepositBtn.setId("homeBtn");
        savingsBtn.setId("homeBtn");
        loanBtn.setId("homeBtn");
        mortgageBtn.setId("homeBtn");

        fixedDepositBtn.setPrefSize(230,70);
        fixedDepositBtn.setLayoutX(550);
        fixedDepositBtn.setLayoutY(160);

        savingsBtn.setPrefSize(230,70);
        savingsBtn.setLayoutX(550);
        savingsBtn.setLayoutY(260);

        loanBtn.setPrefSize(230,70);
        loanBtn.setLayoutX(550);
        loanBtn.setLayoutY(360);

        mortgageBtn.setPrefSize(230,70);
        mortgageBtn.setLayoutX(550);
        mortgageBtn.setLayoutY(460);

        fixedDepositBtn.setOnAction(e -> {
            window.close();
            try {
                FixedDeposit.display();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        savingsBtn.setOnAction(e -> {
            window.close();
            try {
                Saving.display();
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
        homePageRoot.getChildren().addAll(fixedDepositBtn,savingsBtn,loanBtn,mortgageBtn);


        homePageScene = new Scene(homePageRoot,900,700);
        homePageScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());
        homePageRoot.setStyle("-fx-background-color: #f6cd61;");
        window.setScene(homePageScene);
        window.show();
    }

}