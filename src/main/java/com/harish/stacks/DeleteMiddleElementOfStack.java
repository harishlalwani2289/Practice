package com.harish.stacks;
/*
https://www.youtube.com/watch?v=oCcUNRMl7dA&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=8
 */
public class DeleteMiddleElementOfStack {

    public static void main(String[] args) {
        Stack stack =  new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.push(8);

        deleteMiddleElementOfStack(stack, (stack.size()/2 +1));
        stack.displayStack();
    }

    private static void deleteMiddleElementOfStack(Stack stack, int k) {
        if( k == 0) {
            return;
        }
        if (k ==1) {
            stack.pop();
            return;
        }
        int temp = stack.pop();
        deleteMiddleElementOfStack(stack, k-1);
        stack.push(temp);
    }
}
