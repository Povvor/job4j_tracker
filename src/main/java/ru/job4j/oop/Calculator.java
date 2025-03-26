package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public int multiply(int a) {
        return x * a;
    }

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int z) {
        return x - z;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int h) {
        return sum(h) + multiply(h) + minus(h) + divide(h);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println("Sum" + result);
        int minusResult = minus(4);
        System.out.println("Minus= " + minusResult);
        Calculator calculator = new Calculator();
        int multiplyResult = calculator.multiply(5);
        System.out.println("Multiply= " + multiplyResult);
        int divideResult = calculator.divide(10);
        System.out.println("Divide " + divideResult);
        int allOpsResult = calculator.sumAllOperation(15);
        System.out.println("SumOffAllOperation " + allOpsResult);
    }
}