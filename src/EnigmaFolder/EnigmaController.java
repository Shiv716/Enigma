package EnigmaFolder;

import javafx.scene.control.*;

import java.awt.event.ActionEvent;

public class EnigmaController {

    public TextField Rotor1Display;
    public TextField Rotor2Display;
    public TextField Rotor3Display;
    public TextField  Ciphertext;
    public TextField EnterText;
    public Slider Rotor1;
    public Slider Rotor2;
    public Slider Rotor3;


    //Storing the letter provided by the user:-
    private static String d1;

    public static void setD1(String d1) {
        EnigmaController.d1 = d1;
    }

    //Inputs letter from the user:-
    public void cipherInput(ActionEvent actionEvent){
        EnterText.getText();
        d1 = new String(EnterText.getText());
        EnterText.setText(""+d1);
    }


    //Setting values at Rotor1 Slider:-(First need to check if will work nicely.)
    public void rotor1(ActionEvent actionEvent){
        //Assigning the slider:-
        Rotor1 = new Slider();
        //Min value
        Rotor1.setMin(1);
        //Max value
        Rotor1.setMax(26);
        //Setting initial value
        Rotor1.setValue(1);
        //To display ticks
        Rotor1.setShowTickMarks(true);
        //Value between two ticks
        Rotor1.setMajorTickUnit(1);
        //Space between two ticks
        Rotor1.setBlockIncrement(2);
        
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
    public void rotor2(ActionEvent actionEvent){
        Rotor2 = new Slider();
        Rotor2.setMin(0);
        Rotor2.setMax(100);
        Rotor2.setValue(40);
        Rotor2.setShowTickLabels(true);
        Rotor2.setShowTickMarks(true);
        Rotor2.setMajorTickUnit(50);
        Rotor2.setMinorTickCount(5);
        Rotor2.setBlockIncrement(10);
    }



    //Setting values at Rotor3 Slider:-(First need to check if will work nicely.)
    public void rotor3(ActionEvent actionEvent){
        Rotor3 = new Slider();
        Rotor3.setMin(0);
        Rotor3.setMax(26);
        Rotor3.setValue(1);
        Rotor3.setShowTickLabels(true);
        Rotor3.setShowTickMarks(true);
        Rotor3.setMajorTickUnit(13);
        Rotor3.setMinorTickCount(5);
        Rotor3.setBlockIncrement(5);
    }

    //Outputs ciphertext:-
    public void cipherOutput(ActionEvent actionEvent){
//        EnterText.getText();
//        String d1 = new String(EnterText.getText());
        Ciphertext.setText(""+d1);
    }


    //Understand how sliders work
    // - and then assign letters to the textfield
    // Use Enigma file to complete the architect.

    // Figure out why fxml can't load?

}
