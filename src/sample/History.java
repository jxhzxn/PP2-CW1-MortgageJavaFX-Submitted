package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class History {

    public static void display() throws IOException {
        Stage window = new Stage();
        Scene keyBoardScene;
        window.setTitle("History");

        Text historyHead = new Text("Results of the Last Calculation");

        Text simpleSavingHead = new Text("Simple Savings");
        Text simpleSavingRead = new Text();

        Text compoundSavingHead = new Text("Compound Savings");
        Text compoundSavingRead = new Text();

        Text loanHead = new Text("Loan");
        Text loanRead = new Text();


//        Button calculateBtn = new Button("Calculate");
//        calculateBtn.setId("keyboardButton");
//        calculateBtn.setLayoutX(60);
//        calculateBtn.setLayoutY(500);

        simpleSavingRead.setText(FileRead.read("./simpleSaving.txt"));
        compoundSavingRead.setText(FileRead.read("./compoundSaving.txt"));
        loanRead.setText(FileRead.read("./loan.txt"));


        simpleSavingHead.setId("readHead");
        simpleSavingRead.setId("readText");

        compoundSavingHead.setId("readHead");
        compoundSavingRead.setId("readText");

        loanHead.setId("readHead");
        loanRead.setId("readText");

        simpleSavingHead.setLayoutX(30);
        simpleSavingHead.setLayoutY(150);

        simpleSavingRead.setLayoutX(30);
        simpleSavingRead.setLayoutY(200);

        compoundSavingHead.setLayoutX(450);
        compoundSavingHead.setLayoutY(150);

        compoundSavingRead.setLayoutX(450);
        compoundSavingRead.setLayoutY(200);

        loanHead.setLayoutX(30);
        loanHead.setLayoutY(450);

        loanRead.setLayoutX(30);
        loanRead.setLayoutY(500);




        Pane root2 = new Pane();

        root2.getChildren().addAll(
                simpleSavingRead,simpleSavingHead,compoundSavingHead,compoundSavingRead,loanHead,loanRead,TopBar.display(window,0,10)
        );








        keyBoardScene = new Scene(root2,900,700);
        keyBoardScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());
        root2.setStyle("-fx-background-color: #da83b5;");

        window.setScene(keyBoardScene);
        window.show();
    }

    private static int checkAll(TextField... textFields){
        int count = 0;
        for(TextField textField : textFields){
            if (textField.getText().trim().isEmpty()){
                count++;
            }
        }
//        System.out.println(count);
        return count;
    }

    private static void activeCheck(TextField... textFields){
        for (TextField textField : textFields) {
            textField.focusedProperty().addListener((observableValue, oldValue, newValue) -> {
//                System.out.println(textField.getId()+" is Active");
                String active = textField.getId();
            });
        }
    }



    private static TextField createTextField(double x, double y, double j, double k,String id){
        TextField textField = new TextField();
        textField.setLayoutX(x);
        textField.setLayoutY(y);
        textField.setId(id);
        textField.setPrefSize(j,k);

        return textField;
    }

    public ObservableList<String> testing(){
        ObservableList<String> testing = FXCollections.observableArrayList();
        testing.add("hi");
        testing.add("hi1");
        testing.add("hi2");
        testing.add("hi3");

        return testing;
    }





}

