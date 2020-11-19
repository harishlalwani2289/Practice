package com.harish.stacks;

public class SortStackUsingRecursion {

    public static void main(String[] args) {
        Stack stack =  new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.push(8);

        sortStackUsingRecursion(stack);
        stack.displayStack();
    }

    public static void sortStackUsingRecursion(Stack stack) {
        int temp = stack.pop();
        if(stack.isEmpty()) {
            stack.push(temp);
            return;
        }
        sortStackUsingRecursion(stack);
        insertInSortedStack(stack, temp);
    }

    public static void insertInSortedStack(Stack stack, int number) {

        if(stack.isEmpty() || stack.peek() <= number) {
            stack.push(number);
            return;
        }
        int temp  = stack.pop();
        insertInSortedStack(stack, number);
        stack.push(temp);
    }
}
