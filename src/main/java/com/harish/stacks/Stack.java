package com.harish.stacks;

public class Stack {
    public final int SIZE = 20;
    private int[] st;
    private int top;

    public Stack() {
        st = new int[SIZE];
        top = -1;
    }

    public void push(int j){
        st[++top] = j;
    }

    public int pop(){
        return st[top--];
    }

    public int peek() {
        return st[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void displayStack() {
        for(int i = top; i>=0;i-- ) {
            System.out.println(st[i]);
        }
    }

    public int size() {
        return top + 1;
    }
}
