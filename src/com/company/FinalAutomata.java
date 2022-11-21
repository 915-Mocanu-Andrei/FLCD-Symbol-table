package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class FinalAutomata {
    ArrayList<String> elements;
    private int read = 1;
    ArrayList<String> states; //1
    ArrayList<String> alphabet;// 2
    ArrayList<Transition> transitions; // 3
    String initial_state;// 4
    ArrayList<String> final_states;// 5

    public ArrayList<String> getStates() {
        return states;
    }

    public ArrayList<String> getAlphabet() {
        return alphabet;
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public String getInitial_state() {
        return initial_state;
    }

    public FinalAutomata() {
        this.states =new ArrayList<>();
        this.elements = new ArrayList<>();
        this.alphabet = new ArrayList<>();
        this.transitions = new ArrayList<>();
        this.initial_state = "";
        this.final_states = new ArrayList<>();
    }

    public ArrayList<String> getFinal_states() {
        return final_states;
    }

    public void read(String file) {
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            //Let's try the detection part
            while (myReader.hasNextLine()) {
                String element = myReader.nextLine();
                elements.add(element);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(elements);
        for (String i : elements) {
            if (i.charAt(0) == '#'){
                continue; //For putting comments in fa.in
            }
            if (Objects.equals(i, "-")) {
                read++;
                continue;
            }
                if (read == 1){ //States
                    System.out.println("Adding the State: "+i);
                    System.out.println(read);
                    this.states.add(i);}
                if(read == 2){ //Alphabet
                    System.out.println("Adding the Alphabet: "+i);
                    System.out.println(read);
                    this.alphabet.add(i);}
                if(read == 3){//Initial State
                    System.out.println("Adding the Initial State: "+i);
                    System.out.println(read);
                    this.initial_state = i;}
                if (read == 4){//Final State
                    System.out.println("Adding the Final State: "+i);
                    System.out.println(read);
                    this.final_states.add(i);}
                if(read ==5) {
                    System.out.println("Adding the Transition: "+i);
                    this.transitions.add(new Transition(i.charAt(0),i.charAt(1),i.charAt(2)));
                }
        }
    }

    public boolean checkDFA(){
        boolean OK = true;
        // IF DFA Can't transition from one state to two different states through the same l
        for (Transition transition: transitions
             ) {
            for (Transition transition2: transitions
                 ) {
                if (transition.getSource() == transition2.getSource() && transition.getSymbol() == transition2.getSymbol()
                && transition.getDestination() != transition2.getDestination()){
                    OK = false;
                }
            }
        }
        return OK;
    }

    public boolean checkSequence(String sequence) {
        String state = initial_state;
        for(int i=0;i<sequence.length();i++){
            boolean advance = false;
            System.out.println("Making advance false" + i);
            for (Transition transition:
                 transitions) {
                if(transition.getSource() == state.charAt(0) && transition.getSymbol() == sequence.charAt(i)){
                    System.out.println("Moving from "+ transition.getSource() + "to "+ transition.getDestination() + "through" +
                            transition.getSymbol());
                    state ="" + transition.getDestination() ;
                    advance = true;
                    break;
                }
            }
            System.out.println("Checking advance");
            if (!advance || !final_states.contains(state)){
                return false;
            }
        }
        return true;
    }
}
