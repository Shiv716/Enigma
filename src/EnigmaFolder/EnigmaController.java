package EnigmaFolder;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import static EnigmaFolder.Enigma.Machine.RotorValues;

public class EnigmaController implements Initializable {

    public Label Rotor1Display;
    public Label Rotor2Display;
    public Label Rotor3Display;
    public Label  Ciphertext;
    public TextField EnterText;
    public Slider Rotor1;
    public Slider Rotor2;
    public Slider Rotor3;
    public Button CipherGenerator;

    //Creating hashmap for mapping numbers to letters to be used later:-

    public static HashMap<Integer,String> letterByNumber= new HashMap<Integer,String>();

    //mapping them:-
    static{
        letterByNumber.put(1,"A");
        letterByNumber.put(2,"B");
        letterByNumber.put(3,"C");
        letterByNumber.put(4,"D");
        letterByNumber.put(5,"E");
        letterByNumber.put(6,"F");
        letterByNumber.put(7,"G");
        letterByNumber.put(8,"H");
        letterByNumber.put(9,"I");
        letterByNumber.put(10,"J");
        letterByNumber.put(11,"K");
        letterByNumber.put(12,"L");
        letterByNumber.put(13,"M");
        letterByNumber.put(14,"N");
        letterByNumber.put(15,"O");
        letterByNumber.put(16,"P");
        letterByNumber.put(17,"Q");
        letterByNumber.put(18,"R");
        letterByNumber.put(19,"S");
        letterByNumber.put(20,"T");
        letterByNumber.put(21,"U");
        letterByNumber.put(22,"V");
        letterByNumber.put(23,"W");
        letterByNumber.put(24,"X");
        letterByNumber.put(25,"Y");
        letterByNumber.put(26,"Z");

    }


    //Storing the letter provided by the user:-
    public static String d1;
    

    public static void setD1(String d1) {
        EnigmaController.d1 = d1;
    }

    //Inputs letter from the user:-
    public void cipherInput(ActionEvent actionEvent){
//        try{
//            d1 = EnterText.getText();
//        }
//        catch(Exception e){
//            System.out.println("Please enter Capital Letters only");
//        }
//
//        EnterText.setText(""+d1);
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
        try{
            d1 = EnterText.getText();
        }
        catch(Exception e){
            System.out.println("Please enter Capital Letters only");
        }

        EnterText.setText(""+d1);
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


    //To display Slider values in a Label.

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Rotor 1 value displays:-
        Rotor1.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int value = (int) Rotor1.getValue();
                if(letterByNumber.containsKey(value)){
                    String letter_needed = letterByNumber.get(value);
                    Rotor1Display.setText(letter_needed);
                }
            }
        });


        //Rotor 2 value displays:-
        Rotor2.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int value = (int) Rotor2.getValue();
                if(letterByNumber.containsKey(value)){
                    String letter_needed = letterByNumber.get(value);
                    Rotor2Display.setText(letter_needed);
                }
            }
        });


        //Rotor 3 value displays:-
        Rotor3.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int value = (int) Rotor3.getValue();
                if(letterByNumber.containsKey(value)){
                    String letter_needed = letterByNumber.get(value);
                    Rotor3Display.setText(letter_needed);
                }
            }
        });
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
