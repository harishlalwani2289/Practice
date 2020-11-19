package com.harish.linkedlist;

import com.harish.linkedlist.core.LinkedList;
import com.harish.linkedlist.core.Node;

import java.util.Stack;

public class LinkedListPalindromeOrNot {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);
        linkedList.insertFirst(3);

        System.out.println("Linked list is palindrome :" + palindrome(linkedList));
    }

    private static boolean palindrome(LinkedList linkedList) {

        Node head = linkedList.head;
        Stack<Integer> stack = new Stack<>();

        while(head != null){
            stack.push(head.data);
            head = head.next;
        }

        // Lets print the stack and see if the data got populated properly
        stack.stream().forEach(System.out::println);

        head = linkedList.head;

        while(head != null) {
            if(stack.pop() != head.data)
                return false;
            head = head.next;
        }
        return true;
    }
}
