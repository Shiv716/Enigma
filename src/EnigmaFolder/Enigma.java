package sample.EnigmaFolder;

// Start with one rotor , reflector and plugboard.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//import static EnigmaApp.Enigma.Machine.*;
import static sample.EnigmaFolder.Enigma.Machine.*;

public class Enigma {

    // Three rotors:-
//    String[] r1 = new String[]{"A","B","C","D","E"};
//    String[] r2 = new String[]{"F","I","J","K","L"};
//    String[] r3 = new String[]{"M","N","O","P","Q"};


    // Pairs for reflectors : (A,Z);(B,Y);(C,X);(D,W);(E,V);


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

//            // For RotorValues:-
//            //Consider the following list of substitutions for the rotor:-
//            static {
//                RotorValues.put("A",new String("E"));
//                RotorValues.put("B",new String("K"));
//                RotorValues.put("C",new String("F"));
//                RotorValues.put("D",new String("L"));
//                RotorValues.put("E",new String("M"));
//                RotorValues.put("F",new String("G"));
//                RotorValues.put("G",new String("D"));
//                RotorValues.put("H",new String("Q"));
//                RotorValues.put("I",new String("V"));
//            }

            // For Plugboard keys:-
            static {
                Plugboard.put("A",new String("E"));
                Plugboard.put("B",new String("F"));
                Plugboard.put("C",new String("G"));
                Plugboard.put("D",new String("H"));
                Plugboard.put("E",new String("J"));
            }

//            // For Rotor-1 values:-
//            static {
//                r1.add("E");
//                r1.add("K");
//                r1.add("F");
//                r1.add("L");
//                r1.add("M");
//                r1.add("G");
//                r1.add("D");
//                r1.add("Q");
//                r1.add("V");
//            }

            //For Reflector keys:-
            static {
                Reflector.put("A",new String("Z"));
                Reflector.put("B",new String("Y"));
                Reflector.put("C",new String("X"));
                Reflector.put("D",new String("W"));
                Reflector.put("E",new String("V"));
                Reflector.put("F",new String("M"));
                Reflector.put("G",new String("N"));
                Reflector.put("H",new String("O"));
                Reflector.put("I",new String("P"));
                Reflector.put("J",new String("E"));
                Reflector.put("K",new String("K"));
                Reflector.put("L",new String("F"));
                Reflector.put("M",new String("L"));
                Reflector.put("N",new String("G"));
                Reflector.put("O",new String("D"));
                Reflector.put("P",new String("Q"));
                Reflector.put("Q",new String("V"));
                Reflector.put("Z",new String("S"));
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

//             //Splitting the sentence among elements:-
//             String [] arrSplit = letter.split(",");


             //Takes the element individually and helps in finding the plugboard:-

//                 letter = arrSplit[i];
//                 storedArr.add(letter);

                //Must output map of the key.
             if(Plugboard.containsKey(letter)){
                 Plugboardkey = Plugboard.get(letter);
                 //For Check:-
                 System.out.println("Your PlugboardKey:" + Plugboardkey);

             }
            // System.out.println("The element list: "+Arrays.toString(storedArr.toArray()));
//
//                //Must output map of the key.
//             if(Plugboard.containsKey(letter)){
//                 Plugboardkey = Plugboard.get(letter);
//                 //For Check:-
//                 System.out.println("Your PlugboardKey:" + Plugboardkey);
//
//             }
         }


         // We store rotor 1 substitution:-
         public static void Rotor1Value(){
             // For RotorValues:-
             //Consider the following list of substitutions for the rotor:-
              {
                 RotorValues.put("A",new String("E"));
                 RotorValues.put("B",new String("K"));
                 RotorValues.put("C",new String("F"));
                 RotorValues.put("D",new String("L"));
                 RotorValues.put("E",new String("M"));
                 RotorValues.put("F",new String("G"));
                 RotorValues.put("G",new String("D"));
                 RotorValues.put("H",new String("Q"));
                 RotorValues.put("I",new String("V"));
             }

             // For Rotor-1 values:-
             {
                 r1.add("E");
                 r1.add("K");
                 r1.add("F");
                 r1.add("L");
                 r1.add("M");
                 r1.add("G");
                 r1.add("D");
                 r1.add("Q");
                 r1.add("V");
             }

             if (RotorValues.containsKey(Plugboardkey)){
                 Rotor1key= RotorValues.get(Plugboardkey);
                 //For Check:-
                 System.out.println("Your supposed Rotor1 substitution:" +Rotor1key);
             }

         }
         //baba
            //yaga


         // We store rotor 2 substitution:-
         public static void Rotor2Value(){

             // For RotorValues:-
             //Consider the following list of substitutions for the rotor:-
             {
                 RotorValues.put("A",new String("E"));
                 RotorValues.put("B",new String("K"));
                 RotorValues.put("C",new String("F"));
                 RotorValues.put("D",new String("L"));
                 RotorValues.put("E",new String("X"));
                 RotorValues.put("F",new String("G"));
                 RotorValues.put("G",new String("D"));
                 RotorValues.put("H",new String("Q"));
                 RotorValues.put("I",new String("V"));
                 RotorValues.put("M",new String("Y"));
             }

             // For Rotor-2 values:-
             {
                 r2.add("E");
                 r2.add("K");
                 r2.add("F");
                 r2.add("L");
                 r2.add("M");
                 r2.add("G");
                 r2.add("D");
                 r2.add("Q");
                 r2.add("V");
                 r2.add("Y");
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
                 RotorValues.put("A",new String("E"));
                 RotorValues.put("B",new String("K"));
                 RotorValues.put("C",new String("F"));
                 RotorValues.put("D",new String("L"));
                 RotorValues.put("E",new String("X"));
                 RotorValues.put("F",new String("G"));
                 RotorValues.put("G",new String("D"));
                 RotorValues.put("H",new String("Q"));
                 RotorValues.put("I",new String("V"));
                 RotorValues.put("Y",new String("Z"));
             }

             // For Rotor-3 values:-
             {
                 r3.add("E");
                 r3.add("K");
                 r3.add("F");
                 r3.add("L");
                 r3.add("M");
                 r3.add("G");
                 r3.add("D");
                 r3.add("Q");
                 r3.add("V");
                 r3.add("Z");
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

                // Shifting Rotor 1 by 1-1 bits:-
                 if(storedElements.size()==26){
                     ChangePositions(r2);
                 }
                 else if(storedElements.size()==52){
                     ChangePositions(r3);
                 }
                 else{
                     ChangePositions(r1);
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
        * Finish plotting ciphertexts for all elements in the stored arrayList.
        *  */

    }
}



