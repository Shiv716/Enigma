package EnigmaFolder;

// Start with one rotor , reflector and plugboard.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//import static EnigmaApp.Enigma.Machine.*;
import static EnigmaFolder.Enigma.Machine.*;

public class Enigma {


        public static class Machine{

            private static HashMap<String,String> Plugboard = new HashMap<String,String>();
            private static HashMap<String,String> Reflector = new HashMap<String,String>();
            private static String Plugboardkey;
            private static String Rotor1key;
            private static String Rotor2key;
            private static String Rotor3key;

           //Mapping the RotorValues for every element of Rotor:-
            private static HashMap<String,String> RotorValues= new HashMap<String,String>();

//            //Making an arrayList to store all elements to figure out their ciphertext:-
//            private static ArrayList <String > storedArr= new ArrayList<String>();


            //First Rotor:-
            private static ArrayList<String> r1 = new ArrayList<String>(); // Creating the ArrayList object
            //Second Rotor:-
            private static ArrayList<String> r2 = new ArrayList<String>(); // Creating the ArrayList object
            //Third Rotor:-
            private static ArrayList<String> r3 = new ArrayList<String>(); // Creating the ArrayList object

            //Creating an arraylist to keep track of all elements from rotor:-
            private static ArrayList <String> storedElements = new ArrayList<String>();


            // For Plugboard keys:-
            static {
                Plugboard.put("A",new String("E"));
                Plugboard.put("B",new String("F"));
                Plugboard.put("C",new String("G"));
                Plugboard.put("D",new String("H"));
                Plugboard.put("E",new String("J"));
                Plugboard.put("F",new String("J"));
                Plugboard.put("G",new String("J"));
                Plugboard.put("H",new String("J"));
                Plugboard.put("I",new String("J"));
                Plugboard.put("J",new String("J"));
                Plugboard.put("K",new String("J"));
                Plugboard.put("L",new String("J"));
                Plugboard.put("M",new String("J"));
                Plugboard.put("N",new String("J"));
                Plugboard.put("O",new String("J"));
                Plugboard.put("P",new String("J"));
                Plugboard.put("Q",new String("J"));
                Plugboard.put("R",new String("J"));
                Plugboard.put("S",new String("J"));
                Plugboard.put("T",new String("J"));
                Plugboard.put("U",new String("J"));
                Plugboard.put("V",new String("J"));
                Plugboard.put("W",new String("J"));
                Plugboard.put("X",new String("J"));
                Plugboard.put("Y",new String("J"));
                Plugboard.put("Z",new String("J"));
            }


            //For Reflector keys:-
            static {
                Reflector.put("A",new String("E"));
                Reflector.put("B",new String("J"));
                Reflector.put("C",new String("M"));
                Reflector.put("D",new String("Z"));
                Reflector.put("E",new String("A"));
                Reflector.put("F",new String("L"));
                Reflector.put("G",new String("Y"));
                Reflector.put("H",new String("X"));
                Reflector.put("I",new String("V"));
                Reflector.put("J",new String("B"));
                Reflector.put("K",new String("W"));
                Reflector.put("L",new String("F"));
                Reflector.put("M",new String("C"));
                Reflector.put("N",new String("R"));
                Reflector.put("O",new String("Q"));
                Reflector.put("P",new String("U"));
                Reflector.put("Q",new String("O"));
                Reflector.put("R",new String("N"));
                Reflector.put("S",new String("T"));
                Reflector.put("T",new String("S"));
                Reflector.put("U",new String("P"));
                Reflector.put("V",new String("I"));
                Reflector.put("W",new String("K"));
                Reflector.put("X",new String("H"));
                Reflector.put("Y",new String("G"));
                Reflector.put("Z",new String("D"));
            }



         // Substituted value for Input Key:-
         public static void PlugboardOutput(){

             //object of the Scanner class
             Scanner sc = new Scanner(System.in);
             System.out.print("Enter the Letter: ");
//invoking nextInt() method that reads an integer input by keyboard
//storing the input number in a variable num
             String letter = sc.next();
//closing the Scanner after use
             sc.close();
             System.out.println("The letter you entered: " + letter);


                //Must output map of the key.
             if(Plugboard.containsKey(letter)){
                 Plugboardkey = Plugboard.get(letter);
                 //For Check:-
                 System.out.println("Your PlugboardKey:" + Plugboardkey);

             }
         }


         // We store rotor 1 substitution:-
         public static void Rotor1Value(){
             // For RotorValues:-
             //Consider the following list of substitutions for the rotor:-
              {
                 RotorValues.put("A",new String("E"));
                 RotorValues.put("B",new String("K"));
                 RotorValues.put("C",new String("M"));
                 RotorValues.put("D",new String("F"));
                 RotorValues.put("E",new String("L"));
                 RotorValues.put("F",new String("G"));
                 RotorValues.put("G",new String("D"));
                 RotorValues.put("H",new String("Q"));
                 RotorValues.put("I",new String("V"));
                 RotorValues.put("J",new String("Z"));
                 RotorValues.put("K",new String("N"));
                 RotorValues.put("L",new String("T"));
                 RotorValues.put("M",new String("O"));
                 RotorValues.put("N",new String("W"));
                 RotorValues.put("O",new String("Y"));
                 RotorValues.put("P",new String("H"));
                 RotorValues.put("Q",new String("X"));
                 RotorValues.put("R",new String("U"));
                 RotorValues.put("S",new String("S"));
                 RotorValues.put("T",new String("P"));
                 RotorValues.put("U",new String("A"));
                 RotorValues.put("V",new String("I"));
                 RotorValues.put("W",new String("B"));
                 RotorValues.put("X",new String("R"));
                 RotorValues.put("Y",new String("C"));
                 RotorValues.put("Z",new String("J"));
             }

             // For Rotor-1 values:-
             {
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

             if (RotorValues.containsKey(Plugboardkey)){
                 Rotor1key= RotorValues.get(Plugboardkey);
                 //For Check:-
                 System.out.println("Your supposed Rotor1 substitution:" +Rotor1key);
             }

         }


         // We store rotor 2 substitution:-
         public static void Rotor2Value(){

             // For RotorValues:-
             //Consider the following list of substitutions for the rotor:-
             {
                 RotorValues.put("A",new String("A"));
                 RotorValues.put("B",new String("J"));
                 RotorValues.put("C",new String("D"));
                 RotorValues.put("D",new String("K"));
                 RotorValues.put("E",new String("S"));
                 RotorValues.put("F",new String("I"));
                 RotorValues.put("G",new String("R"));
                 RotorValues.put("H",new String("U"));
                 RotorValues.put("I",new String("X"));
                 RotorValues.put("J",new String("B"));
                 RotorValues.put("K",new String("L"));
                 RotorValues.put("L",new String("H"));
                 RotorValues.put("M",new String("W"));
                 RotorValues.put("N",new String("T"));
                 RotorValues.put("O",new String("M"));
                 RotorValues.put("P",new String("C"));
                 RotorValues.put("Q",new String("Q"));
                 RotorValues.put("R",new String("G"));
                 RotorValues.put("S",new String("Z"));
                 RotorValues.put("T",new String("N"));
                 RotorValues.put("U",new String("P"));
                 RotorValues.put("V",new String("Y"));
                 RotorValues.put("W",new String("F"));
                 RotorValues.put("X",new String("V"));
                 RotorValues.put("Y",new String("O"));
                 RotorValues.put("Z",new String("E"));
             }

             // For Rotor-2 values:-
             {
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

             if (RotorValues.containsKey(Rotor1key)){
                 Rotor2key= RotorValues.get(Rotor1key);
                 //For Check:-
                 System.out.println("Your supposed Rotor2 substitution:" +Rotor2key);
             }

         }


         // We store rotor 3 substitution:-
         public static void Rotor3Value(){

             // For RotorValues:-
             //Consider the following list of substitutions for the rotor:-
             {
                 RotorValues.put("A",new String("V"));
                 RotorValues.put("B",new String("Z"));
                 RotorValues.put("C",new String("B"));
                 RotorValues.put("D",new String("R"));
                 RotorValues.put("E",new String("G"));
                 RotorValues.put("F",new String("I"));
                 RotorValues.put("G",new String("T"));
                 RotorValues.put("H",new String("Y"));
                 RotorValues.put("I",new String("U"));
                 RotorValues.put("J",new String("P"));
                 RotorValues.put("K",new String("S"));
                 RotorValues.put("L",new String("D"));
                 RotorValues.put("M",new String("N"));
                 RotorValues.put("N",new String("H"));
                 RotorValues.put("O",new String("L"));
                 RotorValues.put("P",new String("X"));
                 RotorValues.put("Q",new String("A"));
                 RotorValues.put("R",new String("W"));
                 RotorValues.put("S",new String("M"));
                 RotorValues.put("T",new String("J"));
                 RotorValues.put("U",new String("Q"));
                 RotorValues.put("V",new String("O"));
                 RotorValues.put("W",new String("F"));
                 RotorValues.put("X",new String("E"));
                 RotorValues.put("Y",new String("C"));
                 RotorValues.put("Z",new String("K"));
             }

             // For Rotor-3 values:-
             {
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
             if (RotorValues.containsKey(Rotor2key)){
                 Rotor3key= RotorValues.get(Rotor2key);
                 //For Check:-
                 System.out.println("Your supposed Rotor3 substitution:" +Rotor3key);
             }

         }


         //Object for shifting the elements inside an array:-
         //**Thus through this object we ensure rotation of all the rotors whenever needed.
         public static void ChangePositions(ArrayList <String> rotor){

                     //For checking:-
             if(rotor==r2){
                 System.out.println("Therefore new rotated rotor2: "+Arrays.toString(rotor.toArray()));
             }
             if(rotor==r3){
                 System.out.println("Therefore new rotated rotor3: "+Arrays.toString(rotor.toArray()));
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
             }
             catch (Exception e) {
                 System.out.println("Index Error!!");
             }

                //For checking:-
             System.out.println("Therefore new rotated rotor1: "+Arrays.toString(rotor.toArray()));
             System.out.println("Checking for stored Elements: "+Arrays.toString(storedElements.toArray()));

         }


         //Now we finally store reflector substitution:-
         public static void ReflectorKey(){
             if(Reflector.containsKey(Rotor3key)){
                 String reflectorKey = Reflector.get(Rotor3key);
                 System.out.println("Thus , your cipherLetter : "+ reflectorKey);

                // Shifting Rotors by 1-1 bits whenever they are supposed to rotate:-
                 if(storedElements.size()==26){
                     ChangePositions(r2); // when Rotor 1 finishes 1 rotation
                 }
                 else if(storedElements.size()==52){
                     ChangePositions(r3); // when Rotor 2 finishes 1 rotation
                 }
                 else{
                     ChangePositions(r1); // Rotor position changed by one bit after generating one ciphertext.
                 }
             }
         }

        }

    public static void main(String[] args) {

                PlugboardOutput();
                Rotor1Value();
                Rotor2Value();
                Rotor3Value();
                //Working.
                ReflectorKey();


           // Hence , all objects are working correctly.


        /*
        * POINTS TO WORK ON:-
        * Verify if this understanding is correct.
        * /\ Figure out a way to execute ciphertexts for sentences than letters.
        * Make a GUI.
        * Check if after rotation , r1 and r2 need to rotate together or not and ..
        * .. same for r3?
        * ASK FOR PLUGBOARD IDEAS.
        *  */

    }
}



