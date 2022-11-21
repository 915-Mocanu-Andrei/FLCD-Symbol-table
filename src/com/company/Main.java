package com.company;


public class Main {

    public static void main(String[] args) {
        int x;

        SymbolTable sb = new SymbolTable();
        System.out.println(sb.lookup("ceva"));
        System.out.println(sb.lookup("ceva"));
        System.out.println(sb.add("ceva"));
        System.out.println(sb.lookup("ceva"));
        System.out.println(sb.add("ceva"));
        System.out.println(sb.lookup("ceva"));
        System.out.println(sb.lookup("cine"));
        System.out.println(sb.add("cine"));
        System.out.println(sb.lookup("cine"));

        SymbolTable st1 = new SymbolTable();
        SymbolTable st2 = new SymbolTable();
        MyScanner scanner = new MyScanner(st1, st2);
        System.out.println(scanner.scan("p1.txt"));
    }
}
