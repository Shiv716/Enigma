package EnigmaFolder;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;

public class encryptController {
    public Button cipher;
    public ProgressBar encrypting;
    public Label EnigmaLabel;



    public void encipher(ActionEvent actionEvent) throws IOException{

        //After the button is pressed!
            EnigmaLabel.setText("Enigma Ready!");
            encrypting.setProgress(1);

            if(cipher.getText().equals("Open")){
                Parent encrypt_1 = FXMLLoader.load(getClass().getResource("ENIGMA.fxml"));
                Scene encrypt = new Scene(encrypt_1);
                Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(encrypt);
                app_stage.show();
            }

            //Only after this will Enigma Machine begin ;
        cipher.setText("Open");
    }
}