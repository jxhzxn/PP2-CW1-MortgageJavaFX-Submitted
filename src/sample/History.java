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
        Stage historyWindow = new Stage();
        Scene HistoryScene;
        historyWindow.setTitle("History");








        Pane root2 = new Pane();



        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setLayoutY(200);
        tabPane.setLayoutX(100);
        tabPane.setPrefWidth(700);
        tabPane.setPrefHeight(400);



        Tab tab1 = new Tab("savings");
        Tab tab2 = new Tab("Compound");
        Tab tab3 = new Tab("Loan");
        Tab tab4 = new Tab("Mortgage");



        ScrollPane scrollPane1 = new ScrollPane();
        ScrollPane scrollPane2 = new ScrollPane();
        ScrollPane scrollPane3 = new ScrollPane();
        ScrollPane scrollPane4 = new ScrollPane();



        Label lbl1 = new Label(FileRead.read("simpleSaving.txt"));
        Label lbl2 = new Label(FileRead.read("compoundSaving.txt"));
        Label lbl3 = new Label(FileRead.read("loan.txt"));
        Label lbl4 = new Label(FileRead.read("mortgage.txt"));

        lbl1.setId("historyLabel");
        lbl2.setId("historyLabel");
        lbl3.setId("historyLabel");
        lbl4.setId("historyLabel");

        Pane pane1 = new Pane();
        Pane pane2 = new Pane();
        Pane pane3 = new Pane();
        Pane pane4 = new Pane();
        pane1.getChildren().add(lbl1);
        pane2.getChildren().add(lbl2);
        pane3.getChildren().add(lbl3);
        pane4.getChildren().add(lbl4);


        tab1.setContent(scrollPane1);
        tab2.setContent(scrollPane2);
        tab3.setContent(scrollPane3);
        tab4.setContent(scrollPane4);
        scrollPane1.setContent(pane1);
        scrollPane2.setContent(pane2);
        scrollPane3.setContent(pane3);
        scrollPane4.setContent(pane4);
        tabPane.getTabs().addAll(tab1,tab2,tab3,tab4);



        root2.getChildren().addAll(TopBar.display(historyWindow,0,10),tabPane);




        HistoryScene = new Scene(root2,900,700);
        HistoryScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());
        root2.setStyle("-fx-background-color: #da83b5;");

        historyWindow.setScene(HistoryScene);
        historyWindow.show();
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

