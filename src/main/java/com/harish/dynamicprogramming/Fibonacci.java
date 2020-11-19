package com.harish.dynamicprogramming;

public class Fibonacci {
    int lookUp[];
    public Fibonacci(int n) {
        lookUp = new int[n+1];
    }

    public int fib(int n) {
        if (lookUp[n] == 0) {

            if (n<=1)
                lookUp[n] = n;
            else
                lookUp[n] = fib(n-1) + fib(n-2);
        }

        return lookUp[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(10);
        System.out.println(fibonacci.fib(10));
    }
}
