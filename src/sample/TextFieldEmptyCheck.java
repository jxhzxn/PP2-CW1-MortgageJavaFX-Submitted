package sample;

import javafx.scene.control.TextField;

    public class TextFieldEmptyCheck {

        public static int check(TextField... textFields){
            int count = 0;
            for(TextField textField : textFields){
                if (textField.getText().trim().isEmpty()){
                    count++;
                }
            }
            return count;
        }
}
