package EnigmaFolder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class EnigmaController {

    public Label Rotor1Display;
    public Label Rotor2Display;
    public Label Rotor3Display;
    public Label  Ciphertext;
    public TextField EnterText;
    public Spinner <String> Rotor1;
    public Spinner <String> Rotor2;
    public Spinner <String> Rotor3;
    public Button CipherGenerator;

    //Storing the letter provided by the user:-
    public static String d1;
    

    public static void setD1(String d1) {
        EnigmaController.d1 = d1;
    }

    //Inputs letter from the user:-
    public void cipherInput(ActionEvent actionEvent){
        try{
            d1 = EnterText.getText();
        }
        catch(Exception e){
            System.out.println("Please enter Capital Letters only");
        }

        EnterText.setText(""+d1);
    }


    //Setting values at Rotor1 Slider:-(First need to check if will work nicely.)

        
        // Using the switch statement to assign letters to digits chosen:-
        //MAYBE USE VALUE TO SEE WHAT IS CHOSEN IN SLIDER?
//        switch(digit){
//            case 1 :
//                letter = "A";
//                break;
//            case 2 :
//
//
//        }


    //Setting values at Rotor2 Slider:-(First need to check if will work nicely.)

    //Setting values at Rotor3 Slider:-(First need to check if will work nicely.)

    //Outputs ciphertext:-

    public void cipherInput(javafx.event.ActionEvent actionEvent) {
    }

    public void generateCipher(javafx.event.ActionEvent actionEvent) throws IOException, InterruptedException {

        String d1 = new String(EnterText.getText());
        Ciphertext.setText(""+d1.toUpperCase());
        EnterText.clear();
    }

    public void keyA(javafx.event.ActionEvent actionEvent) {
    }

    public void keyB(javafx.event.ActionEvent actionEvent) {
    }

//    Parent encrypt_1= FXMLLoader.load(getClass().getResource("encrypt.fxml"));
//    Scene encrypt = new Scene(encrypt_1);
//    Stage app_stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
//        app_stage.hide();
//        app_stage.setScene(encrypt);
//        app_stage.show();
//    //encrypt_1.getScene();
//        Ciphertext.setText(""+d1);
//


    /*
    //use spinners for rotors
    // - and then assign letters to the textfield
     - Give 6 plugboard key options as spinners or menu box
    // Use Enigma file to complete the architecture.
     */
}
