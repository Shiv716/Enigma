package EnigmaFolder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainEnigma extends Application {

    // Loads the Enigma:-

    @Override
    public void start(Stage primaryStage) throws IOException //throws Exception
     {
        Parent root = FXMLLoader.load(getClass().getResource("ENIGMA.fxml"));
        primaryStage.setTitle("Enigma Machine");
        primaryStage.setScene(new Scene(root, 700, 603));
        primaryStage.show();
    }
}