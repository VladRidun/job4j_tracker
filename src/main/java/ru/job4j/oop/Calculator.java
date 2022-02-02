package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int minus(int y) {
        return y - x;
    }

    public static int sum(int y) {
        return x + y;
    }

    public int devide(int y) {
        return y / x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int intsumAllOperation(int y) {
        return minus(y) + sum(y) + devide(y) + multiply(y);
    }

    public static void main(String[] args) {
        int one = 1;
        int two = 2;
        int result;

        Calculator calculator = new Calculator();
        result = calculator.intsumAllOperation(10);
        System.out.println("intsumAllOperation = " + result);
/*
        result = one + two;
        System.out.println(result);
        one = 6;
        result = one / two;
        System.out.println(result);
        one = 5;
        result = one - two;
        System.out.println(result);
        one = two * 2;
        result = one * two;
        System.out.println(result);

*/
    }
}