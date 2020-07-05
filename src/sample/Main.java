package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{

        HomePage.display();



//        homepage = primaryStage;
//        homepage.setTitle("Welcome to the Calculator");

        //HomePageButtons
//        Button fixedDepositBtn = new Button("Fixed Deposit");
//        Button savingsBtn = new Button("Savings");
//        Button loanBtn = new Button("Loan");
//        Button mortgageBtn = new Button("Mortgage");
//
//        fixedDepositBtn.setId("homeBtn");
//        savingsBtn.setId("homeBtn");
//        loanBtn.setId("homeBtn");
//        mortgageBtn.setId("homeBtn");
//
//
//        fixedDepositBtn.setPrefSize(180,50);
//        fixedDepositBtn.setLayoutX(120);
//        fixedDepositBtn.setLayoutY(100);
//
//        savingsBtn.setPrefSize(180,50);
//        savingsBtn.setLayoutX(120);
//        savingsBtn.setLayoutY(170);
//
//        loanBtn.setPrefSize(180,50);
//        loanBtn.setLayoutX(120);
//        loanBtn.setLayoutY(240);
//
//        mortgageBtn.setPrefSize(180,50);
//        mortgageBtn.setLayoutX(120);
//        mortgageBtn.setLayoutY(310);
//
//        fixedDepositBtn.setOnAction(e -> {
//            homepage.close();
//            try {
//                FixedDeposit.display();
//            } catch (FileNotFoundException fileNotFoundException) {
//                fileNotFoundException.printStackTrace();
//            }
//        });
//
//        savingsBtn.setOnAction(e -> {
//            homepage.close();
//            Saving.display();
//        });
//
//        loanBtn.setOnAction(e -> {
//            homepage.close();
//            Loan.display();
//        });
//
//        mortgageBtn.setOnAction(e -> {
//            homepage.close();
//            Mortgage.display();
//        });
//
//
//
//        Pane homePageRoot = new Pane();
//        homePageRoot.getChildren().addAll(fixedDepositBtn,savingsBtn,loanBtn,mortgageBtn);
//
//        homePageScene = new Scene(homePageRoot,400,400);
//        homePageScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
//
//        primaryStage.setScene(homePageScene);
//        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}