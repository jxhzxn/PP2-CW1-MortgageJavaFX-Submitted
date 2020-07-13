package sample;
import javafx.scene.control.Alert;

public class WarningBox {

    //method to create a custom alertbox
    public static Alert display(String title, String content){
        Alert alertBox = new Alert(Alert.AlertType.WARNING);
        alertBox.setHeaderText(title);
        alertBox.setContentText(content);
        alertBox.showAndWait();
        return alertBox;
    }
}
