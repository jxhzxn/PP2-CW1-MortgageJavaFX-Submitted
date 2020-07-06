package sample;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WarningBox {
//    public static void display(String title, String message){
//        Stage window = new Stage();
//
//        window.initModality(Modality.APPLICATION_MODAL);
//        window.setTitle(title);
//        window.setMinWidth(250);
//
//        Label label = new Label();
//        label.setText(message);
//
//        Button closeBtn = new Button("Okay");
//        closeBtn.setOnAction(e->{
//            window.close();
//        });
//
//        Pane root = new Pane();
//        Scene scene = new Scene(root);
//        window.setScene(scene);
//        window.show();
//    }

    public static Alert display(String title, String content){
        Alert alertBox = new Alert(Alert.AlertType.WARNING);
        alertBox.setHeaderText(title);
        alertBox.setContentText(content);
        alertBox.showAndWait();
        return alertBox;
    }
}
