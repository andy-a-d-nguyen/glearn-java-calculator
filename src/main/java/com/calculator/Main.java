package com.calculator;

public class Main {
    public static void main(String[] args){
        int result = 0;
        try {
            result = new Calculator().add("1,2\n3");
        } catch (NegativeNumException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
