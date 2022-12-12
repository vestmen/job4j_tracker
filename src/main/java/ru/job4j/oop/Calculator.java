package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + minus(a) + multiply(a) + divide(a);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int sum = sum(10);
        System.out.println(sum);
        int multiply = calculator.multiply(5);
        System.out.println(multiply);
        int minus = minus(10);
        System.out.println(minus);
        int divide = calculator.multiply(5);
        System.out.println(divide);
        int sumAll = calculator.sumAllOperation(5);
        System.out.println(sumAll);
    }
}
