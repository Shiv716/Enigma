package EnigmaFolder;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.*;

//Importing Enigma class objects:-
import static EnigmaFolder.Enigma.Machine.*;

public class EnigmaController implements Initializable {

    public Label Rotor1Display;
    public Label Rotor2Display;
    public Label Rotor3Display;
    public TextArea Ciphertext;
    public TextArea EnterText;
    public Slider Rotor1;
    public Slider Rotor2;
    public Slider Rotor3;
    public Button CipherGenerator;
    public Button Rotor1Button;
    public Button Rotor2Button;
    public Button Rotor3Button;
    public Button Clear;
    public Button PlugkeyButton;
    public Spinner <String> plugKey1A;
    public Spinner <String> plugKey1B;
    public Spinner <String> plugKey2A;
    public Spinner <String> plugKey2B;
    public Spinner <String> plugKey3A;
    public Spinner <String> plugKey3B;
    public Spinner <String> plugKey4A;
    public Spinner <String> plugKey4B;
    public Spinner <String> plugKey5A;
    public Spinner <String> plugKey5B;
    public Spinner <String> plugKey6A;
    public Spinner <String> plugKey6B;
    public Spinner <String> plugKey7A;
    public Spinner <String> plugKey7B;
    public Spinner <String> plugKey8A;
    public Spinner <String> plugKey8B;
    public Spinner <String> plugKey9A;
    public Spinner <String> plugKey9B;
    public Spinner <String> plugKey10A;
    public Spinner <String> plugKey10B;


    // Spinner values:-
    public SpinnerValueFactory<String> key1A;
    public SpinnerValueFactory<String> key1B;
    public SpinnerValueFactory<String> key2A;
    public SpinnerValueFactory<String> key2B;
    public SpinnerValueFactory<String> key3A;
    public SpinnerValueFactory<String> key3B;
    public SpinnerValueFactory<String> key4A;
    public SpinnerValueFactory<String> key4B;
    public SpinnerValueFactory<String> key5A;
    public SpinnerValueFactory<String> key5B;
    public SpinnerValueFactory<String> key6A;
    public SpinnerValueFactory<String> key6B;
    public SpinnerValueFactory<String> key7A;
    public SpinnerValueFactory<String> key7B;
    public SpinnerValueFactory<String> key8A;
    public SpinnerValueFactory<String> key8B;
    public SpinnerValueFactory<String> key9A;
    public SpinnerValueFactory<String> key9B;
    public SpinnerValueFactory<String> key10A;
    public SpinnerValueFactory<String> key10B;


    //Creating hashmap for mapping numbers to letters to be used later:-

    public static HashMap<Integer,String> letterByNumber= new HashMap<Integer,String>();

    //mapping them:-
    //Specially for setting spinner values:
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
    public String d1;

    private static String letter_needed;


    //Inputs letter from the user:-

    public void cipherInput(javafx.event.ActionEvent actionEvent) {
        try{
            d1 = EnterText.getText();
        }
        catch(Exception e){
            System.out.println("One Exception dodged!");
        }

        EnterText.setText(""+d1);
    }


    //Outputs ciphertext:-
    public void generateCipher(javafx.event.ActionEvent actionEvent) throws IOException, InterruptedException {

        //Setting text values to labels:
        Rotor1Display.setText(r1.get(0));
        Rotor2Display.setText(r2.get(0));
        Rotor3Display.setText(r3.get(0));

        //  Setting the input from user to pass into functional object:-
        stringElement = EnterText.getText();

        try{
        if(EnterText.getText()!=null){
            getCipher(); // Calling the function to get cipher;
        }else{
            EnterText.setText(null);
        }
        }catch (Exception e) {
            System.out.println("Please input only letters.");
        }

            //Gets the cipherText:-
            Ciphertext.setText("" + finalCipher);

        //Setting on the ROTOR KNOBS so that we can initialize and change values if needed:-
        Rotor1.setDisable(false);
        Rotor2.setDisable(false);
        Rotor3.setDisable(false);

    }


    //BUTTONS TO CHANGE ROTATIONS OF ROTORS:-
    public void Rotor1Change(ActionEvent actionEvent) {

        //Changing the orientation of rotor if button pressed:-
            rotor1Set(letter_needed);
            storedElements.clear();
            //Re-setting the knob at 0 after choosing value:
            Rotor1.setValue(0);
    }

    public void Rotor2Change(ActionEvent actionEvent) {
        //Changing the orientation of rotor if button pressed:-
            rotor2Set(letter_needed);
            storedElements.clear();
        //Re-setting the knob at 0 after choosing value:
            Rotor2.setValue(0);
    }

    public void Rotor3Change(ActionEvent actionEvent) {
        //Changing the orientation of rotor if button pressed:-
            rotor3Set(letter_needed);
            storedElements.clear();
        //Re-setting the knob at 0 after choosing value:
            Rotor3.setValue(0);
    }


    //TO SWAP KEYS ON PLUGBOARD:-
    public void PlugSwap(ActionEvent actionEvent) {
        //MAKING OBJECTS FOR SWAPPING VALUES OF SPINNERS WHENEVER INTERACTED:

        // FOR PLUG-KEYS 1A AND 1B:-
        key1A = plugKey1A.getValueFactory();
        key1B = plugKey1B.getValueFactory();
        if(!key1A.equals(key1B)){
            String keyA = key1A.getValue();
            String keyB = key1B.getValue();
            PlugboardKeys(keyA, keyB);
            //For Verifying:- (WORKING!)
            System.out.println("Plugboard orientation: "+Arrays.toString(Plugboard.toArray()));
        }

        // FOR PLUG-KEYS 2A AND 2B:-
        key2A = plugKey2A.getValueFactory();
        key2B = plugKey2B.getValueFactory();
        if(!key2A.equals(key2B)){
            String keyA = key2A.getValue();
            String keyB = key2B.getValue();
            PlugboardKeys(keyA,keyB);
        }

        // FOR PLUG-KEYS 3A AND 3B:-
        key3A = plugKey3A.getValueFactory();
        key3B = plugKey3B.getValueFactory();
        if(!key3A.equals(key3B)){
            String keyA = key3A.getValue();
            String keyB = key3B.getValue();
            PlugboardKeys(keyA,keyB);
        }

        // FOR PLUG-KEYS 4A AND 4B:-
        key4A = plugKey4A.getValueFactory();
        key4B = plugKey4B.getValueFactory();
        if(!key4A.equals(key4B)){
            String keyA = key4A.getValue();
            String keyB = key4B.getValue();
            PlugboardKeys(keyA,keyB);
        }

        // FOR PLUG-KEYS 5A AND 5B:-
        key5A = plugKey5A.getValueFactory();
        key5B = plugKey5B.getValueFactory();
        if(!key5A.equals(key5B)){
            String keyA = key5A.getValue();
            String keyB = key5B.getValue();
            PlugboardKeys(keyA,keyB);
        }

        // FOR PLUG-KEYS 6A AND 6B:-
        key6A = plugKey6A.getValueFactory();
        key6B = plugKey6B.getValueFactory();
        if(!key6A.equals(key6B)){
            String keyA = key6A.getValue();
            String keyB = key6B.getValue();
            PlugboardKeys(keyA,keyB);
        }

        // FOR PLUG-KEYS 7A AND 7B:-
        key7A = plugKey7A.getValueFactory();
        key7B = plugKey7B.getValueFactory();
        if(!key7A.equals(key7B)){
            String keyA = key7A.getValue();
            String keyB = key7B.getValue();
            PlugboardKeys(keyA,keyB);
        }

        // FOR PLUG-KEYS 8A AND 8B:-
        key8A = plugKey8A.getValueFactory();
        key8B = plugKey8B.getValueFactory();
        if(!key8A.equals(key8B)){
            String keyA = key8A.getValue();
            String keyB = key8B.getValue();
            PlugboardKeys(keyA,keyB);
        }

        // FOR PLUG-KEYS 9A AND 9B:-
        key9A = plugKey9A.getValueFactory();
        key9B = plugKey9B.getValueFactory();
        if(!key9A.equals(key9B)){
            String keyA = key9A.getValue();
            String keyB = key9B.getValue();
            PlugboardKeys(keyA,keyB);
        }

        // FOR PLUG-KEYS 10A AND 10B:-
        key10A = plugKey10A.getValueFactory();
        key10B = plugKey10B.getValueFactory();
        if(!key10A.equals(key10B)){
            String keyA = key10A.getValue();
            String keyB = key10B.getValue();
            PlugboardKeys(keyA,keyB);
        }
    }

    //Just clear the text field:
    public void ClearButton(ActionEvent actionEvent) {
        Ciphertext.clear();
        finalCipher=""; // To empty the storage string for Cipher.
    }

    //To display Slider values in a Label.
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Rotor 1 value displays:-
        Rotor1.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                int value = (int) Rotor1.getValue();
                Rotor1.setValue((value));

                //Disabling the slider after 1 shift to ensure not over shifting
                Rotor1.setDisable(true);
                try{
                    letter_needed = r1.get(value);
                    //Setting the values from UI to rotor 1:-
                    Rotor1Display.setText(letter_needed);
                    System.out.println("1st rotor key: " + Rotor1key);
                }
                catch(Exception e){
                    System.out.println("Index out of Bounds error dodged!");
                }

            }

        });


        //Rotor 2 value displays:-
        Rotor2.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int value = (int) Rotor2.getValue();
                Rotor2.setValue((value));
                //Disabling the slider after 1 shift to ensure not over shifting
                Rotor2.setDisable(true);

                try{
                    letter_needed = r2.get(value);
                    //Setting the values from UI to rotor 2:-
                    Rotor2Display.setText(letter_needed);

                }
                catch(Exception e){
                    System.out.println("Index out of Bounds error dodged!");
                }
                }

        });


        //Rotor 3 value displays:-
        Rotor3.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int value = (int) Rotor3.getValue();
                Rotor3.setValue((value));
                //Disabling the slider after 1 shift to ensure not over shifting
                Rotor3.setDisable(true);

                try {
                    letter_needed = r3.get(value);
                    //Setting the values from UI to rotor 3:-
                    Rotor3Display.setText(letter_needed);

                } catch (Exception e) {
                    System.out.println("Index out of Bounds error dodged!");
                }
            }

        });


        //USER GETS 6 PLUG-BOARD KEYS TO SWAP THE VALUES SO 6 OPTIONS TO CHOOSE FROM IF WANTED
        // - FOR ADDING CHANGING VALUES BEFORE THE ELEMENT ENTERS THE ROTORS.

        //Making the spinners:-

        //Making an observable list of all values of our hashmap to be used in spinner factory as Strings:-
        ObservableList<String> justLetters = FXCollections.observableArrayList();
        justLetters.addAll(letterByNumber.values());


        //Spinners :

        //Spinner 1A:-
        SpinnerValueFactory<String> valueFactory1A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 1B:-
        SpinnerValueFactory<String> valueFactory1B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 2A:-
        SpinnerValueFactory<String> valueFactory2A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 2B:-
        SpinnerValueFactory<String> valueFactory2B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 3A:-
        SpinnerValueFactory<String> valueFactory3A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 3B:-
        SpinnerValueFactory<String> valueFactory3B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 4A:-
        SpinnerValueFactory<String> valueFactory4A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 4B:-
        SpinnerValueFactory<String> valueFactory4B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 5A:-
        SpinnerValueFactory<String> valueFactory5A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 5B:-
        SpinnerValueFactory<String> valueFactory5B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 6A:-
        SpinnerValueFactory<String> valueFactory6A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 6B:-
        SpinnerValueFactory<String> valueFactory6B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 7A:-
        SpinnerValueFactory<String> valueFactory7A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 7B:-
        SpinnerValueFactory<String> valueFactory7B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 8A:-
        SpinnerValueFactory<String> valueFactory8A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 8B:-
        SpinnerValueFactory<String> valueFactory8B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 9A:-
        SpinnerValueFactory<String> valueFactory9A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 9B:-
        SpinnerValueFactory<String> valueFactory9B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 10B:-
        SpinnerValueFactory<String> valueFactory10A = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);
        //Spinner 10B:-
        SpinnerValueFactory<String> valueFactory10B = new SpinnerValueFactory.ListSpinnerValueFactory<String>(justLetters);



        //Now setting initial values to them:-

        //Spinner 1A:
        valueFactory1A.setValue("A");
        plugKey1A.setValueFactory(valueFactory1A);
        //Spinner 1B:
        valueFactory1B.setValue("A");
        plugKey1B.setValueFactory(valueFactory1B);
        //Spinner 2A:
        valueFactory2A.setValue("A");
        plugKey2A.setValueFactory(valueFactory2A);
        //Spinner 2B:
        valueFactory2B.setValue("A");
        plugKey2B.setValueFactory(valueFactory2B);
        //Spinner 3A:
        valueFactory3A.setValue("A");
        plugKey3A.setValueFactory(valueFactory3A);
        //Spinner 3B:
        valueFactory3B.setValue("A");
        plugKey3B.setValueFactory(valueFactory3B);
        //Spinner 4A:
        valueFactory4A.setValue("A");
        plugKey4A.setValueFactory(valueFactory4A);
        //Spinner 4B:
        valueFactory4B.setValue("A");
        plugKey4B.setValueFactory(valueFactory4B);
        //Spinner 5A:
        valueFactory5A.setValue("A");
        plugKey5A.setValueFactory(valueFactory5A);
        //Spinner 5B:
        valueFactory5B.setValue("A");
        plugKey5B.setValueFactory(valueFactory5B);
        //Spinner 6A:-
        valueFactory6A.setValue("A");
        plugKey6A.setValueFactory(valueFactory6A);
        //Spinner 6B:-
        valueFactory6B.setValue("A");
        plugKey6B.setValueFactory(valueFactory6B);
        //Spinner 7A:-
        valueFactory7A.setValue("A");
        plugKey7A.setValueFactory(valueFactory7A);
        //Spinner 7B:-
        valueFactory7B.setValue("A");
        plugKey7B.setValueFactory(valueFactory7B);
        //Spinner 8A:-
        valueFactory8A.setValue("A");
        plugKey8A.setValueFactory(valueFactory8A);
        //Spinner 8B:-
        valueFactory8B.setValue("A");
        plugKey8B.setValueFactory(valueFactory8B);
        //Spinner 9A:-
        valueFactory9A.setValue("A");
        plugKey9A.setValueFactory(valueFactory9A);
        //Spinner 9B:-
        valueFactory9B.setValue("A");
        plugKey9B.setValueFactory(valueFactory9B);
        //Spinner 10A:-
        valueFactory10A.setValue("A");
        plugKey10A.setValueFactory(valueFactory10A);
        //Spinner 10B:-
        valueFactory10B.setValue("A");
        plugKey10B.setValueFactory(valueFactory10B);


        /*
        NOTES:-
        LOOK OUT FOR STORED ELEMENTS ARRAY , NOT TO MANIPULATE TOTAL ROTATION OF ROTORS.
        - ASK IF THE ROTATION SEQUENCE IS OKAY OR NOT?
        - ASK IF ENCRYPTION IS SYMMETRIC OR NOT?
         */

    }

    public void CipherOutput(MouseEvent mouseEvent) {
    }

}
