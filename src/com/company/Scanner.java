package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;

public class Scanner {
    SymbolTable st1;
    SymbolTable st2;
    //regex


    public Scanner(SymbolTable st1, SymbolTable st2) {
        this.st1 = st1;
        this.st2 = st2;
    }

    public String scan(String doc) {
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
        //endwhile
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line = "";
            //Let's try the detect part
            while (line != null){
                line = reader.readLine();
                int position = -1;
                while (position<line.length()){
                    position++;
                    //Here we do the IFs
                    //Separators:
                    if(line.charAt(position) == ' '){
                        //genPIF(' ',0)
                    }
                    if(line.charAt(position) == '|'){
                        //genPIF('|',0)
                    }
                    if(line.charAt(position) == '\n'){
                        //genPIF('\n',0)
                    }
                    if(line.charAt(position) == '"'){
                        //genPIF('"',0)
                    }
                    if(line.charAt(position) == '\''){
                        //genPIF(''',0)
                    }
                    //Reserved Word
                    //Token.in
                    if('a'< line.charAt(position) && line.charAt(position) < 'z' &&
                            'A'< line.charAt(position) && line.charAt(position) < 'Z'){
                        if (line.substring(position, position+2).equals("nr")){
                            //genPIF("nr", 1)
                        }
                        if (line.substring(position, position+2).equals("NR")){
                            //genPIF("NR", 1)
                        }
                    }
                }
            }
            return null;
            } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
