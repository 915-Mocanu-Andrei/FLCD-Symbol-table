package com.company;


public class Transition {
    char source;
    char symbol;
    char destination;

    public Transition(char source, char symbol, char destination) {
        this.source = source;
        this.symbol = symbol;
        this.destination = destination;
    }

    public char getSource() {
        return source;
    }

    public void setSource(char source) {
        this.source = source;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public char getDestination() {
        return destination;
    }

    public void setDestination(char destination) {
        this.destination = destination;
    }

    @Override
    public String toString(){
        return "Source:" + source + "  Symbol:" + symbol +"  Destination:" + destination;
    }
}
