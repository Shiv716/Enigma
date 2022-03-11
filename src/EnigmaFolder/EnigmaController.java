package EnigmaFolder;

import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;

public class EnigmaController {

    public Label Rotor1Display;
    public Label Rotor2Display;
    public Label Rotor3Display;
    public Label  Ciphertext;
    public TextField EnterText;
    public Slider Rotor1;
    public Slider Rotor2;
    public Slider Rotor3;


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
   {
        
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
    }

    //Setting values at Rotor2 Slider:-(First need to check if will work nicely.)

    //Setting values at Rotor3 Slider:-(First need to check if will work nicely.)

    //Outputs ciphertext:-

    public void cipherInput(javafx.event.ActionEvent actionEvent) {
        EnterText.getText();
        String d1 = new String(EnterText.getText());
        Ciphertext.setText(""+d1.toUpperCase());
    }

    public void rotor1(MouseEvent mouseEvent) {

        Rotor1.getValue();
        int r1 = (int) Rotor1.getValue();
        Rotor1Display.setText(""+ r1);

    }

    public void rotor2(MouseEvent mouseEvent) {

    }

    public void rotor3(MouseEvent mouseEvent) {

    }

    public void generateCipher(javafx.event.ActionEvent actionEvent) {

    }


    //Understand how sliders work
    // - and then assign letters to the textfield
    // Use Enigma file to complete the architecture.

}
