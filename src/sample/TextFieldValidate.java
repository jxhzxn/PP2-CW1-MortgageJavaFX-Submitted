package sample;
import javafx.scene.control.TextField;

import java.util.Arrays;


public class TextFieldValidate {

        public static int check(TextField... textFields){
            int count = 0;
            for(TextField textField : textFields){
                if (textField.getText().trim().isEmpty()){
                    count++;
                }
            }
            return count;
        }

        public static int stringCheck(String... values){
            int returnVal = 0;
            try{
                double checked = Double.parseDouble(Arrays.toString(values));
                returnVal = 1;
            }
            catch (NumberFormatException e){
               returnVal = 2;
            }
            return returnVal;
        }

    }
