package com.company;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class SymbolTable {

    public SymbolTable(){
        this.table = new ArrayList[100];
        for(int i=0;i<100;i++){
            this.table[i] = new ArrayList<Tuple<String,Integer>>();
        }
    }

    ArrayList<Tuple<String,Integer>>[] table;// the string is the token, the Integer is the Code
    int last_code = -1;
    //explicat structura + hash function + diagrama de ceva chestie
    public int hash(String token){
        return token.hashCode()%100;
    }

    public Integer add(String token){
        //if there is already a entry for the hashed key
        if(!table[(hash(token))].isEmpty()) {
            for (int i = 0; i < table[(hash(token))].size(); i++) {
                //if the token is already stored
                if (Objects.equals(table[(hash(token))].get(i).x, token)){
                    return table[(hash(token))].get(i).y;
                }
            }
            //if the token is not already stored
            last_code++;
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
}
