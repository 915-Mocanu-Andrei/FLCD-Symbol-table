package com.company;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static java.lang.Math.abs;

public class SymbolTable {

    public SymbolTable(){
        this.table = new ArrayList[100];
        for(int i=0;i<100;i++){
            this.table[i] = new ArrayList<Tuple<String,Integer>>();
        }
    }

    ArrayList<Tuple<String,Integer>>[] table;// the string is the token, the Integer is the Code
    int last_code = 0;
    //explicat structura + hash function + diagrama de ceva chestie
    public int hash(String token){
        return abs(token.hashCode() % 100);
    }

    public Integer add(String token){
        //if there is already a entry for the hashed key
        if (hash(token) == -93) {
            System.out.println("The TOKEN: "+token);
        }
        if(!table[(hash(token))].isEmpty()) {
            for (int i = 0; i < table[(hash(token))].size(); i++) {
                //if the token is already stored
                if (Objects.equals(table[(hash(token))].get(i).x, token)){
                    return table[(hash(token))].get(i).y;
                }
            }
            //if the token is not already stored
            last_code++;
            System.out.println("It got here");
            table[(hash(token))].add(new Tuple<>(token,last_code));
            return last_code;
        }
        //if there isn't already a entry for the hashed key
        last_code++;
        table[(hash(token))].add(new Tuple<>(token,last_code));
        return last_code;
    }

    public Integer lookup(String token){
        //if there is already a entry for the hashed key
        if(!table[(hash(token))].isEmpty()) {
            for (int i = 0; i < table[(hash(token))].size(); i++){
                //if the token is already stored
                if (Objects.equals(table[(hash(token))].get(i).x, token)){
                    return table[(hash(token))].get(i).y;
                }
            }
            //if the token is not already stored
            return -1;
        }
        //if there isn't already a entry for the hashed key
        return -1;
    }

    public ArrayList<Tuple<String,Integer>> getSymbolTable(){
        ArrayList<Tuple<String,Integer>> outputTable= new ArrayList<Tuple<String,Integer>>();
        System.out.println("Last code:"+last_code);
        for (int i=0; i < 100; i++){
            for (Tuple<String,Integer> entry : this.table[i]){
                System.out.println("Entry:" + entry);
                outputTable.add(entry);
            }
        }
        return outputTable;
    }
}
