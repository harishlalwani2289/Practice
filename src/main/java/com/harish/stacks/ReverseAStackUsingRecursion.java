package com.harish.stacks;

public class ReverseAStackUsingRecursion {
    public static void main(String[] args) {
        Stack stack =  new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.push(8);
        System.out.println("Before reversing");
        stack.displayStack();
        reverseStack(stack);
        System.out.println("After reversing");
        stack.displayStack();
    }

    public static void reverseStack(Stack stack) {

        if(stack.isEmpty())
            return;

        int temp = stack.pop();
        reverseStack(stack);
        insertAtLast(stack, temp);
    }

    public static void insertAtLast(Stack stack, int number) {

        if(stack.isEmpty()) {
            stack.push(number);
            return;
        }
        int temp = stack.pop();
        insertAtLast(stack, number);
        stack.push(temp);
    }




}
