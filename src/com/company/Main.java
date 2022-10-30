package com.company;

public class Main {

    public static void main(String[] args) {
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
    }
}
