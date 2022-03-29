package EnigmaFolder;

// Start with one rotor , reflector and plugboard.

import com.google.common.primitives.Chars;

import java.util.*;

//import static EnigmaApp.Enigma.Machine.*;
import static EnigmaFolder.Enigma.Machine.*;

public class Enigma {


    public static class Machine {

        public static ArrayList<String> OriginalPlugboard = new ArrayList<String>();
        public static ArrayList<String> Plugboard = new ArrayList<String>();
        public static HashMap<String, String> Reflector = new HashMap<String, String>();
        public static String Plugboardkey;
        public static String Rotor1key;
        public static String Rotor2key;
        public static String Rotor3key;
        public static String Rotor1keyBackward;
        public static String Rotor2keyBackward;
        public static String Rotor3keyBackward;
        public static String PlugboardValueBackward;
        public static String reflectorKey;

        //Mapping the RotorValues for every element of Rotor (For referencing the rotor value with original letter positions):-
        public static HashMap<String, String> RotorValues = new HashMap<String, String>();

        //First Rotor:-
        public static ArrayList<String> r1 = new ArrayList<String>(); // Creating the ArrayList object
        //Second Rotor:-
        public static ArrayList<String> r2 = new ArrayList<String>(); // Creating the ArrayList object
        //Third Rotor:-
        public static ArrayList<String> r3 = new ArrayList<String>(); // Creating the ArrayList object

        //Creating an arraylist to keep track of all elements from rotor:-
        public static ArrayList<String> storedElements = new ArrayList<String>();


        // Converting a string to a list of characters;
        public static List<Character> chars;

        //Making a string to store plugboard keys;
        public static String stringElement;

        //stores final cipher :
        public static String finalCipher = "";


        // For Original Plug-board values:-
        static {
            OriginalPlugboard.add("A");
            OriginalPlugboard.add("B");
            OriginalPlugboard.add("C");
            OriginalPlugboard.add("D");
            OriginalPlugboard.add("E");
            OriginalPlugboard.add("F");
            OriginalPlugboard.add("G");
            OriginalPlugboard.add("H");
            OriginalPlugboard.add("I");
            OriginalPlugboard.add("J");
            OriginalPlugboard.add("K");
            OriginalPlugboard.add("L");
            OriginalPlugboard.add("M");
            OriginalPlugboard.add("N");
            OriginalPlugboard.add("O");
            OriginalPlugboard.add("P");
            OriginalPlugboard.add("Q");
            OriginalPlugboard.add("R");
            OriginalPlugboard.add("S");
            OriginalPlugboard.add("T");
            OriginalPlugboard.add("U");
            OriginalPlugboard.add("V");
            OriginalPlugboard.add("W");
            OriginalPlugboard.add("X");
            OriginalPlugboard.add("Y");
            OriginalPlugboard.add("Z");
        }


        // For Plugboard keys that can be updated:-
        static {
            Plugboard.add("A");
            Plugboard.add("B");
            Plugboard.add("C");
            Plugboard.add("D");
            Plugboard.add("E");
            Plugboard.add("F");
            Plugboard.add("G");
            Plugboard.add("H");
            Plugboard.add("I");
            Plugboard.add("J");
            Plugboard.add("K");
            Plugboard.add("L");
            Plugboard.add("M");
            Plugboard.add("N");
            Plugboard.add("O");
            Plugboard.add("P");
            Plugboard.add("Q");
            Plugboard.add("R");
            Plugboard.add("S");
            Plugboard.add("T");
            Plugboard.add("U");
            Plugboard.add("V");
            Plugboard.add("W");
            Plugboard.add("X");
            Plugboard.add("Y");
            Plugboard.add("Z");
        }

        // For Rotor-1 values:-

        static {
            r1.add("E");
            r1.add("K");
            r1.add("M");
            r1.add("F");
            r1.add("L");
            r1.add("G");
            r1.add("D");
            r1.add("Q");
            r1.add("V");
            r1.add("Z");
            r1.add("N");
            r1.add("T");
            r1.add("O");
            r1.add("W");
            r1.add("Y");
            r1.add("H");
            r1.add("X");
            r1.add("U");
            r1.add("S");
            r1.add("P");
            r1.add("A");
            r1.add("I");
            r1.add("B");
            r1.add("R");
            r1.add("C");
            r1.add("J");
        }

        // For Rotor-2 values:-
        static {
            r2.add("A");
            r2.add("J");
            r2.add("D");
            r2.add("K");
            r2.add("S");
            r2.add("I");
            r2.add("R");
            r2.add("U");
            r2.add("X");
            r2.add("B");
            r2.add("L");
            r2.add("H");
            r2.add("W");
            r2.add("T");
            r2.add("M");
            r2.add("C");
            r2.add("Q");
            r2.add("G");
            r2.add("Z");
            r2.add("N");
            r2.add("P");
            r2.add("Y");
            r2.add("F");
            r2.add("V");
            r2.add("O");
            r2.add("E");
        }

        // For Rotor-3 values:-
        static {
            r3.add("V");
            r3.add("Z");
            r3.add("B");
            r3.add("R");
            r3.add("G");
            r3.add("I");
            r3.add("T");
            r3.add("Y");
            r3.add("U");
            r3.add("P");
            r3.add("S");
            r3.add("D");
            r3.add("N");
            r3.add("H");
            r3.add("L");
            r3.add("X");
            r3.add("A");
            r3.add("W");
            r3.add("M");
            r3.add("J");
            r3.add("Q");
            r3.add("O");
            r3.add("F");
            r3.add("E");
            r3.add("C");
            r3.add("K");
        }

        //For Reflector keys:-
        static {
            Reflector.put("A", new String("E"));
            Reflector.put("B", new String("J"));
            Reflector.put("C", new String("M"));
            Reflector.put("D", new String("Z"));
            Reflector.put("E", new String("A"));
            Reflector.put("F", new String("L"));
            Reflector.put("G", new String("Y"));
            Reflector.put("H", new String("X"));
            Reflector.put("I", new String("V"));
            Reflector.put("J", new String("B"));
            Reflector.put("K", new String("W"));
            Reflector.put("L", new String("F"));
            Reflector.put("M", new String("C"));
            Reflector.put("N", new String("R"));
            Reflector.put("O", new String("Q"));
            Reflector.put("P", new String("U"));
            Reflector.put("Q", new String("O"));
            Reflector.put("R", new String("N"));
            Reflector.put("S", new String("T"));
            Reflector.put("T", new String("S"));
            Reflector.put("U", new String("P"));
            Reflector.put("V", new String("I"));
            Reflector.put("W", new String("K"));
            Reflector.put("X", new String("H"));
            Reflector.put("Y", new String("G"));
            Reflector.put("Z", new String("D"));
        }


        // Substituted value for Input Key:-
        public static void PlugboardOutput(String letter) {
            //Setting Plugboard key.
            if (Plugboard.contains(letter.toUpperCase())) {
                int index = OriginalPlugboard.indexOf(letter.toUpperCase());
                Plugboardkey = Plugboard.get(index);
                System.out.println("Plugboard key: " + Plugboardkey);
            }
        }


        //This object rotates the rotor to set in the given element as first letter:-
        public static void rotor1Set(String j) {
            //Loop rotates rotor until given element is the first one.

            while (!j.toUpperCase().equals(r1.get(0))) {

                ChangePositions(r1);
                storedElements.clear();
            }

             System.out.println("Thus , we obtain new set and rotated motor: "+ Arrays.toString(r1.toArray()));
        }


        //This object rotates the rotor to set in the given element as first letter(FOR ROTOR2)
        public static void rotor2Set(String j) {
            //Loop rotates rotor until given element is the first one.

            while (!j.toUpperCase().equals(r2.get(0))) {

                ChangePositions(r2);
                storedElements.clear();
            }

            System.out.println("Thus , we obtain new set and rotated motor: " + Arrays.toString(r2.toArray()));
        }


        //This object rotates the rotor to set in the given element as first letter(FOR ROTOR3)
        public static void rotor3Set(String j) {
            //Loop rotates rotor until given element is the first one.

            while (!j.toUpperCase().equals(r3.get(0))) {

                ChangePositions(r3);
                storedElements.clear();
            }

            System.out.println("Thus , we obtain new set and rotated motor: " + Arrays.toString(r3.toArray()));
        }


        //Thus , this object swaps the values of keys.
        public static void PlugboardKeys(String keyA, String keyB) {

            //Finding the index of key which is supposed to be substituted.
            int i = Plugboard.indexOf(keyA);

            //Storing index of 2nd key:-
            int j = Plugboard.indexOf(keyB);

            Plugboard.set(i, keyB); // Substituting the 2nd key at informed index.
            // Finishing the swap of the 2nd key as well.
            Plugboard.set(j, keyA);
        }


        // We store rotor 1 substitution:-
        public static void Rotor1ValueForward() {
            // For RotorValues:-
            //Consider the following list of substitutions for the rotor:-
            //(Just for Reference: )
            {
                RotorValues.put("A", new String("E"));
                RotorValues.put("B", new String("K"));
                RotorValues.put("C", new String("M"));
                RotorValues.put("D", new String("F"));
                RotorValues.put("E", new String("L"));
                RotorValues.put("F", new String("G"));
                RotorValues.put("G", new String("D"));
                RotorValues.put("H", new String("Q"));
                RotorValues.put("I", new String("V"));
                RotorValues.put("J", new String("Z"));
                RotorValues.put("K", new String("N"));
                RotorValues.put("L", new String("T"));
                RotorValues.put("M", new String("O"));
                RotorValues.put("N", new String("W"));
                RotorValues.put("O", new String("Y"));
                RotorValues.put("P", new String("H"));
                RotorValues.put("Q", new String("X"));
                RotorValues.put("R", new String("U"));
                RotorValues.put("S", new String("S"));
                RotorValues.put("T", new String("P"));
                RotorValues.put("U", new String("A"));
                RotorValues.put("V", new String("I"));
                RotorValues.put("W", new String("B"));
                RotorValues.put("X", new String("R"));
                RotorValues.put("Y", new String("C"));
                RotorValues.put("Z", new String("J"));
            }

            int index = OriginalPlugboard.indexOf(Plugboardkey);//Storing input element's index
            Rotor1key = r1.get(index);//Making substitution
            //For Check:-
            System.out.println("index: " + index);
            System.out.println("Your supposed Rotor1 substitution:" + Rotor1key);

        }


        // We store rotor 2 substitution:-
        public static void Rotor2ValueForward() {

            // For RotorValues:-
            //Consider the following list of substitutions for the rotor:-
            //(Just for Reference: )
            {
                RotorValues.put("A", new String("A"));
                RotorValues.put("B", new String("J"));
                RotorValues.put("C", new String("D"));
                RotorValues.put("D", new String("K"));
                RotorValues.put("E", new String("S"));
                RotorValues.put("F", new String("I"));
                RotorValues.put("G", new String("R"));
                RotorValues.put("H", new String("U"));
                RotorValues.put("I", new String("X"));
                RotorValues.put("J", new String("B"));
                RotorValues.put("K", new String("L"));
                RotorValues.put("L", new String("H"));
                RotorValues.put("M", new String("W"));
                RotorValues.put("N", new String("T"));
                RotorValues.put("O", new String("M"));
                RotorValues.put("P", new String("C"));
                RotorValues.put("Q", new String("Q"));
                RotorValues.put("R", new String("G"));
                RotorValues.put("S", new String("Z"));
                RotorValues.put("T", new String("N"));
                RotorValues.put("U", new String("P"));
                RotorValues.put("V", new String("Y"));
                RotorValues.put("W", new String("F"));
                RotorValues.put("X", new String("V"));
                RotorValues.put("Y", new String("O"));
                RotorValues.put("Z", new String("E"));
            }

            int index = OriginalPlugboard.indexOf(Rotor1key); //Storing input element's index
            Rotor2key = r2.get(index); //Making substitution
            //For Check:-
            System.out.println("index: " + index);
            System.out.println("Your supposed Rotor2 substitution:" + Rotor2key);
        }



        // We store rotor 3 substitution:-
        public static void Rotor3ValueForward() {
            // For RotorValues:-
            //Consider the following list of substitutions for the rotor:-
            // (Just for Reference)
            {
                RotorValues.put("A", new String("V"));
                RotorValues.put("B", new String("Z"));
                RotorValues.put("C", new String("B"));
                RotorValues.put("D", new String("R"));
                RotorValues.put("E", new String("G"));
                RotorValues.put("F", new String("I"));
                RotorValues.put("G", new String("T"));
                RotorValues.put("H", new String("Y"));
                RotorValues.put("I", new String("U"));
                RotorValues.put("J", new String("P"));
                RotorValues.put("K", new String("S"));
                RotorValues.put("L", new String("D"));
                RotorValues.put("M", new String("N"));
                RotorValues.put("N", new String("H"));
                RotorValues.put("O", new String("L"));
                RotorValues.put("P", new String("X"));
                RotorValues.put("Q", new String("A"));
                RotorValues.put("R", new String("W"));
                RotorValues.put("S", new String("M"));
                RotorValues.put("T", new String("J"));
                RotorValues.put("U", new String("Q"));
                RotorValues.put("V", new String("O"));
                RotorValues.put("W", new String("F"));
                RotorValues.put("X", new String("E"));
                RotorValues.put("Y", new String("C"));
                RotorValues.put("Z", new String("K"));
            }

            int index = OriginalPlugboard.indexOf(Rotor2key);//Storing input element's index
            Rotor3key = r3.get(index); //Making substitution
            //For Check:-
            System.out.println("Index : " +index);
            System.out.println("Your supposed Rotor3 substitution:" + Rotor3key);
        }


        //Object for shifting the elements inside an array:-
        //**Thus through this object we ensure rotation of all the rotors whenever needed.
        public static void ChangePositions(ArrayList<String> rotor) {

            //For checking:-
            if (rotor == r2) {
                System.out.println("Therefore new rotated rotor2: " + Arrays.toString(rotor.toArray()));
            }
            if (rotor == r3) {
                System.out.println("Therefore new rotated rotor3: " + Arrays.toString(rotor.toArray()));
            }


            //Storing the value of first element;
            String temp = rotor.get(0);

            //ADDING THE SKIPPED ELEMENTS:-
            storedElements.add(temp);

            //Skipping the first element to obtain new array:-
            rotor.remove(0);

            //Adding the element at last part so as to obtain new rotated rotor array:-
            try {
                rotor.add(temp);
            } catch (Exception e) {
                System.out.println("Index Error!!");
            }

            //For checking:-
            System.out.println("Therefore new rotated rotor1: " + Arrays.toString(rotor.toArray()));
            System.out.println("Checking for stored Elements: " + Arrays.toString(storedElements.toArray()));
            System.out.println("Size of stored Elements: " + storedElements.size());

        }


        //Now we finally store reflector substitution:-
        public static void ReflectorKey() {
            reflectorKey = Reflector.get(Rotor3key);
            System.out.println("Thus , your cipherLetter : " + reflectorKey);

        }

        //Reverts back important key (reverse value) of Rotor3Key
        public static void Rotor3valueBackward() {

            int index = r3.indexOf(reflectorKey); //Storing the element considering index
            Rotor3keyBackward = OriginalPlugboard.get(index);// Getting final substitution
            //For verifying:-
            System.out.println("Rotor 3 key reverse: "+Rotor3keyBackward);
        }

        //Reverts back important key (reverse value) of Rotor2Key
        public static void Rotor2valueBackward() {
            int index = r2.indexOf(Rotor3keyBackward); //Storing the element considering index
            Rotor2keyBackward = OriginalPlugboard.get(index); // Getting final substitution
            //For verifying:-
            System.out.println("Rotor 2 key reverse: "+Rotor2keyBackward);
        }

        //Reverts back important key (reverse value) of Rotor1Key
        public static void Rotor1valueBackward() {

            int index = r1.indexOf(Rotor2keyBackward); //Storing the element considering index
            Rotor1keyBackward = OriginalPlugboard.get(index);// Getting final substitution
            //For verifying:-
            System.out.println("Rotor 1 key reverse: "+Rotor1keyBackward);
        }


        //Reverts back important key (reverse value) of Plugboardkey
        public static void PlugboardvalueBackward() {

            int index =OriginalPlugboard.indexOf(Rotor1keyBackward); //Storing the element considering index
           PlugboardValueBackward = Plugboard.get(index);// Getting final substitution
            //For verifying:-
            System.out.println("Plugboard value reverse: "+ PlugboardValueBackward);

            //Thus final cipher letter : PlugboardValueBackward;
        }


        //Working all the objects to get the result cipher :
        public static void getCipher() {

            chars = Chars.asList(stringElement.toCharArray());
            for (int i = 0; i < chars.size(); i++) {
                //Making sure the element from char is not free space;
                Character c = chars.get(i);
                String s = String.valueOf(c);
                //BELOW WE MAKING SURE TO FILTER AND ENCIPHER JUST LETTERS FROM INPUT:-
                if (stringElement != null && !s.equals(" ")) {
                    PlugboardOutput(String.valueOf(chars.get(i)));
                    Rotor1ValueForward();
                    Rotor2ValueForward();
                    Rotor3ValueForward();
                    ReflectorKey();
                    Rotor3valueBackward();
                    Rotor2valueBackward();
                    Rotor1valueBackward();
                    PlugboardvalueBackward();

                    //GIVES OUT FINAL CIPHER SENTENCE:-
                    finalCipher = finalCipher.concat(PlugboardValueBackward);

                    //NOW AFTER EVERY EXECUTION AND GENERATION OF A CIPHER , THE ROTORS WILL MOVE WHENEVER NEEDED TO :-
                    ChangePositions(r1);// WILL ROTATE ALWAYS
                    if(storedElements.size() % 676 == 0){
                        ChangePositions(r3); // WILL ROTATE AFTER EVERY ONE CYCLE OF EXECUTION OF ROTOR2
                    }
                    if (storedElements.size() % 26 == 0) {
                        ChangePositions(r2); // WILL ROTATE AFTER EVERY ONE CYCLE OF EXECUTION OF ROTOR 1
                    }
                    //Making sure to limit encryption until 26*26*26 encryptions;
                    if(storedElements.size()==676*26){
                        storedElements.clear();
                        System.out.println("Encryption terminated!");
                        System.out.println("Now it will need to restart.");
                    }
                }
                else {
                    System.out.println("null");
                }
            }
        }
    }
}






