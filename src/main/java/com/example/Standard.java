package com.example;

public class Standard {
    public int add(int a ,int b){
        return a+b;
    }
    public int subtract(int a ,int b){
        return a-b;
    }
    public int multiply(int a ,int b){
        return a*b;
    }
    public int divide(int a , int b){
        if(b==0) throw new ArithmeticException("denominator can  not be zero ");
        else return a/b;
    }

    public boolean isEvenNumber(int num){
        if(num%2==0) return true;
        else return false;
    }

    public boolean isPalindrome(String s)
    {
        StringBuilder sb=new StringBuilder(s);
        StringBuilder reverse = sb.reverse();
        if(s.equals(reverse.toString())) return true;
        else return false;
    }
}

