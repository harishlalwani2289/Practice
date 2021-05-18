package practice.harish.stacks;

import java.util.Stack;

public class MaintainMinimumAtTop {

    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();
        pushAndProcess(numbers,2);
        pushAndProcess(numbers, 3);
        pushAndProcess(numbers,1);
        pushAndProcess(numbers,15);
        pushAndProcess(numbers, 4);
        pushAndProcess(numbers,-1);

        System.out.println(numbers.pop());
        System.out.println(numbers.pop());
        System.out.println(numbers.pop());
        System.out.println(numbers.pop());
        System.out.println(numbers.pop());
        System.out.println(numbers.pop());
    }

    private static void pushAndProcess(Stack<Integer> numbers, int i) {

        if(numbers.isEmpty()) {
            numbers.push(i);
        }
        else {
            if(numbers.peek() > i ) {
                numbers.push(i);
            } else {
                int temp = numbers.pop();
                pushAndProcess(numbers, i);
                numbers.push(temp);
            }
        }
    }
}
