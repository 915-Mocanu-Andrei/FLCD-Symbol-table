package com.company;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class MyScanner {
    SymbolTable st1;//identifiers
    SymbolTable st2;//constants
    ArrayList<Tuple<String,Integer>> pif;
    ArrayList<String> tokens;
    //regex

    public MyScanner(SymbolTable st1, SymbolTable st2){
        this.st1 = st1;
        this.st2 = st2;
        this.pif = new ArrayList<>();
        this.tokens = new ArrayList<>();
    }

    public void genPIF(String token, Integer position){
        pif.add(new Tuple<>(token,position));
    }

    public String scan(String doc){
        //Guidance
        //Algorithm Scanning v2
        //While (not(eof)) do
        //detect(token);
        //if token is reserved word OR operator OR separator
        //then genPIF(token, 0)
        //else
        //if token is identifier OR constant
        //then index = pos(token, ST);
        //genPIF(token, index)
        //else message “Lexical error”
        //endif
        //endif
        //end while

        //First.
        //Get all the tokens from token.in
        try{
            File myObj = new File("token.in");
            Scanner myReader = new Scanner(myObj);
            //Let's try the detection part
            while (myReader.hasNextLine()){
                String token = myReader.nextLine();
                tokens.add(token);
                System.out.println(token);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(tokens);

        try {
            File myObj = new File(doc);
            Scanner myReader = new Scanner(myObj);
            int lineNr = 0;
            int columnNr = 0;
            //Let's try the detect part
            while (myReader.hasNextLine()){
                lineNr++;
                columnNr++;
                String line1 = myReader.nextLine();
                String line = line1.trim().replaceAll(" +", " ");
                String[] words = line.split("[\\s']");
                int position = -1;
                for(String token : words){
                    //Here we do the IFs
                    //Separators:
                    if(tokens.contains(token)){
                        genPIF(token,0);
                    }
                    else{
                        if(token.matches("[a-zA-Z][a-zA-Z0-9]*"))
                            //Identifier
                        {System.out.println("Token:" + token);
                            genPIF("id",st1.add(token));
                            System.out.println(st1.lookup(token));
                        }
                        else
                            if (token.matches("[0-9]*"))
                                //Number constant
                                genPIF("co",st2.add(token));
                            else
                            if (token.matches("\"[a-zA-Z0-9!@#$%^&*()_+=]*\"")){
                                //String constant
                                System.out.println(token + "MATCHES STRING");
                                genPIF("co",st2.add(token));}
                            else
                                return "Lexical error at " + lineNr +":"+ columnNr+ " token="+ token;
                    }
                }
            }
            } catch (Exception e){
            e.printStackTrace();
        }
        String fiveSpaces = "     ";
        //for ()
        //Let's write to PIF.out and ST.out
        try {
            File myObj = new File("PIF.out");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());

                //Write
                FileWriter myWriter = new FileWriter("PIF.out");
                myWriter.write("-------------------");
                myWriter.write("\n");
                for (Tuple<String,Integer> x: pif){
                    myWriter.write("| "+ x.x + fiveSpaces.substring(0,5 - x.x.toString().length() % 5)
                            + "|" + x.y + fiveSpaces.substring(0,5 - x.y.toString().length()) + "|");
                    myWriter.write("\n");
                }
                myWriter.write("-------------------");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("ST.out");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());

                //Write
                FileWriter myWriter = new FileWriter("ST.out");
                myWriter.write("\n");
                myWriter.write("ST1:");
                myWriter.write("\n");
                myWriter.write("----------------");
                myWriter.write("\n");
                for (Tuple<String,Integer> x: st1.getSymbolTable()){
                    myWriter.write("| "+ x.x +fiveSpaces.substring(0,5 - x.x.toString().length())
                            + "|" + x.y + fiveSpaces.substring(0,5 - x.y.toString().length()) + "|");
                    myWriter.write("\n");
                }
                myWriter.write("----------------");
                myWriter.write("\n");
                myWriter.write("\n");
                myWriter.write("\n");
                myWriter.write("ST2:");
                myWriter.write("\n");
                myWriter.write("----------------");
                myWriter.write("\n");
                for (Tuple<String,Integer> x: st2.getSymbolTable()){
                    myWriter.write("| "+ x.x + "|" + x.y + "|");
                    myWriter.write("\n");
                }
                myWriter.write("-------------------");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return "";
    }
}
//diagrama clasa
//strcturi date PIF, ST
//explicate regexurile
//moodle github pana data viitoare