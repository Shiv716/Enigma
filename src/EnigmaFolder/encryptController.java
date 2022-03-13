package EnigmaFolder;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class encryptController {

       public Button cipher;
       public ProgressBar encrypting;
       int increaseProgress;

    public void encipher(ActionEvent actionEvent) throws IOException {
        Parent encrypt_1= FXMLLoader.load(getClass().getResource("ENIGMA.fxml"));
        Scene encrypt = new Scene(encrypt_1);
        Stage app_stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(encrypt);
        app_stage.show();

        increaseProgress+=100;
        encrypting.setProgress(increaseProgress);

    }
}
