package com.company;

import java.util.Scanner;

public class MainAutomata {

    public static void main(String[] args) {
        FinalAutomata automata = new FinalAutomata();
        automata.read("fa.in");
        System.out.println("Final states:"+automata.getFinal_states());
        System.out.println(automata.checkDFA());
        int x =1;
        //System.out.println("alphabet: "+automata.getAlphabet());
        while (x!=0) {
            //Verificare prin DFA
            //acceptare
            //in run i think
            // class Transition
            System.out.println("What do you want to see?");
            System.out.println("1.The States");
            System.out.println("2.The alphabet");
            System.out.println("3.The transitions");
            System.out.println("4.The initial state");
            System.out.println("5.The final states");
            System.out.println("6.I want to check a sequence");
            System.out.println("0.Exit");
            System.out.print("=");
            Scanner scanner = new Scanner(System.in);
            x = scanner.nextInt();
            if (x == 1) {
                for (String state : automata.getStates()) {
                    System.out.println(state);
                }
            }
            if (x == 2) {
                for (String alphabet : automata.getAlphabet()) {
                    System.out.println(alphabet);
                }
            }
            if (x == 3) {
                for (String transition : automata.getTransitions()) {
                    System.out.println(transition);
                }
            }
            if (x == 4) {
                System.out.println(automata.getInitial_state());
            }
            if (x == 5) {
                for (String final_state : automata.getFinal_states()) {
                    System.out.println(final_state);
                }
            }
            if(x == 6){
                if(automata.checkDFA()) {
                    String seq = scanner.nextLine();
                    seq = scanner.nextLine();
                    if( automata.checkSequence(seq)){
                        System.out.println("Good sequence :)");
                    }
                    else{
                        System.out.println("Bad Sequence :(");
                    }
                }
                else
                    System.out.println("Not a DFA");
            }
        }
    }
}
