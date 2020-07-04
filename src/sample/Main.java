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

public class Main extends Application {

    Stage homepage,fixedDepositStage;
    Scene homePageScene, fixedDepositScene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        homepage = primaryStage;
        homepage.setTitle("Welcome to the Calculator");


        //HomePageButtons
        Button fixedDepositBtn = new Button("Fixed Deposit");
        Button savingsBtn = new Button("Savings");
        Button loanBtn = new Button("Loan");
        Button mortgageBtn = new Button("Mortgage");

        fixedDepositBtn.setPrefSize(150,50);
        fixedDepositBtn.setLayoutX(120);
        fixedDepositBtn.setLayoutY(100);

        savingsBtn.setPrefSize(150,50);
        savingsBtn.setLayoutX(120);
        savingsBtn.setLayoutY(170);

        loanBtn.setPrefSize(150,50);
        loanBtn.setLayoutX(120);
        loanBtn.setLayoutY(240);

        mortgageBtn.setPrefSize(150,50);
        mortgageBtn.setLayoutX(120);
        mortgageBtn.setLayoutY(310);

        fixedDepositBtn.setOnAction(e -> {
//            fixedDepositStage = primaryStage;
//            fixedDepositStage.setTitle("Fixed Deposit");
//            homepage.setScene(fixedDepositScene);
            homepage.close();
            FixedDeposit.display();
        });






        //Keyboard Buttons

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







        Pane homePageRoot = new Pane();
        homePageRoot.getChildren().addAll(fixedDepositBtn,savingsBtn,loanBtn,mortgageBtn);

        Pane fixedDepositRoot = new Pane();
        fixedDepositRoot.getChildren().addAll();



        homePageScene = new Scene(homePageRoot,400,400);
        fixedDepositScene = new Scene(fixedDepositRoot,400,400);



        primaryStage.setScene(homePageScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}