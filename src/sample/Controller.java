package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private Button add_contact_btn; //Initializing the New Window Button
    @FXML
    private Button view_contact_btn;
    @FXML
    private Button quit_btn;
    @FXML
    private Button back_btn;
    @FXML
    private Button save_btn;


    public void new_window() throws IOException{ //Function for New Window Button
        Stage stage = (Stage) add_contact_btn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Main.java"));
        primaryStage.setTitle("Add Contact");
        primaryStage.setScene(new Scene(root, 600,400));
        primaryStage.show();
    }

    public void quit_window() throws IOException{ //Function for Close Button
        Stage stage = (Stage) add_contact_btn.getScene().getWindow();
        stage.close();
    }

    public void go_previous() throws IOException{ //Function for Back Button
        Stage stage = (Stage) back_btn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Home");
        primaryStage.setScene(new Scene(root,600,600));
        primaryStage.show();
    }

    public void contact_added() throws IOException{ //Function for Alert
        Stage stage = (Stage) back_btn.getScene().getWindow();
        stage.close();

        Stage secondaryStage = new Stage();
        Parent roote = FXMLLoader.load(getClass().getResource("sample.fxml"));
        secondaryStage.setTitle("Home");
        secondaryStage.setScene(new Scene(roote,600,600));
        secondaryStage.show();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("alert.fxml"));
        primaryStage.setTitle("Alert");
        primaryStage.setScene(new Scene(root,600,300));
        primaryStage.show();
    }

    public void contact_view() throws IOException{ //Function for Contacts Table
        Stage stage = (Stage) add_contact_btn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("contacts.fxml"));
        primaryStage.setTitle("Contacts");
        primaryStage.setScene(new Scene(root, 600,400));
        primaryStage.show();
    }

}
