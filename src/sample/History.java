package sample;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class History {

    public static void display() throws IOException {
        Stage historyWindow = new Stage();
        Scene HistoryScene;
        historyWindow.setTitle("History");

        //creating the pane
        Pane root2 = new Pane();

        //creating the tabpane
        TabPane tabPane = new TabPane();

        //disabling the closing button of the tabs
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        //setting the layout of the tabpane
        tabPane.setLayoutY(100);
        tabPane.setLayoutX(250);
        tabPane.setPrefWidth(400);
        tabPane.setPrefHeight(500);

        //creating 4 tabs
        Tab tab1 = new Tab("savings");
        Tab tab2 = new Tab("Compound");
        Tab tab3 = new Tab("Loan");
        Tab tab4 = new Tab("Mortgage");

        //setting the IDs for the tabs
        tab1.setId("tab");
        tab2.setId("tab");
        tab3.setId("tab");
        tab4.setId("tab");

        //creating 4 scrollpanes
        ScrollPane scrollPane1 = new ScrollPane();
        ScrollPane scrollPane2 = new ScrollPane();
        ScrollPane scrollPane3 = new ScrollPane();
        ScrollPane scrollPane4 = new ScrollPane();

        //setting the ID for the scrollpane
        scrollPane1.setId("scrollPane");

        //creating 4 labels and reading the data from the files by calling the fileread method
        Label lbl1 = new Label(FileRead.read("simpleSaving.txt"));
        Label lbl2 = new Label(FileRead.read("compoundSaving.txt"));
        Label lbl3 = new Label(FileRead.read("loan.txt"));
        Label lbl4 = new Label(FileRead.read("mortgage.txt"));

        //setting the layout of each labels
        lbl1.setLayoutX(30);
        lbl2.setLayoutX(30);
        lbl3.setLayoutX(30);
        lbl4.setLayoutX(30);

        //setting the IDs to the labels
        lbl1.setId("historyLabel");
        lbl2.setId("historyLabel");
        lbl3.setId("historyLabel");
        lbl4.setId("historyLabel");

        //creating panes
        Pane pane1 = new Pane();
        Pane pane2 = new Pane();
        Pane pane3 = new Pane();
        Pane pane4 = new Pane();

        //adding the labels inside the relevant panes
        pane1.getChildren().add(lbl1);
        pane2.getChildren().add(lbl2);
        pane3.getChildren().add(lbl3);
        pane4.getChildren().add(lbl4);


        //adding the scrollpanes inside the tabs
        tab1.setContent(scrollPane1);
        tab2.setContent(scrollPane2);
        tab3.setContent(scrollPane3);
        tab4.setContent(scrollPane4);

        //adding the panes inside the scrollpanes
        scrollPane1.setContent(pane1);
        scrollPane2.setContent(pane2);
        scrollPane3.setContent(pane3);
        scrollPane4.setContent(pane4);
        tabPane.getTabs().addAll(tab1,tab2,tab3,tab4);

        root2.getChildren().addAll(TopBar.display(historyWindow,0,10),tabPane);

        HistoryScene = new Scene(root2,900,700);
        HistoryScene.getStylesheets().add(HomePage.class.getResource("stylesheet.css").toExternalForm());
        root2.setStyle("-fx-background-color: #7d7769;");

        historyWindow.setScene(HistoryScene);
        historyWindow.show();
    }

}

