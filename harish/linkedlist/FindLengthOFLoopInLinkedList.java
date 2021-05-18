package practice.harish.linkedlist;

import practice.harish.linkedlist.core.LinkedList;
import practice.harish.linkedlist.core.Node;

/**
 * Write a function detectAndCountLoop() that checks whether a given Linked List contains loop and if loop is present then returns count of nodes in loop.
 * For example, the loop is present in below-linked list and length of the loop is 4. If the loop is not present, then the function should return 0.
 */
public class FindLengthOFLoopInLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node node1 = linkedList.insertAndReturnNode(5);
        linkedList.insertAndReturnNode(4);
        linkedList.insertAndReturnNode(3);
        Node node2 = linkedList.insertAndReturnNode(2);
        linkedList.insertAndReturnNode(1);
        node1.next = node2;

        // We have made a loop in a linked list
        // Let's first write code to detect a loop in linked list
        if(detectALoop(linkedList)) {
            System.out.println("Loop hain");
            // Now we have got the loop we will have to find the length of the loop
            System.out.println("Length of the loop is : " + findTheLengthOfTheLoop(linkedList));
        }
    }

    private static int findTheLengthOfTheLoop(LinkedList linkedList) {
        Node fast = linkedList.head;
        Node slow = linkedList.head;

        do {
            if(fast.next == null || fast.next.next == null){
                return 0;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while(fast != slow);

        int length = 1;
        fast = fast.next;
        while (fast != slow) {
            if(fast.next != null) {
                length++;
                fast = fast.next;
            }
        }
        return length;
    }

    private static boolean detectALoop(LinkedList linkedList) {
        Node fast = linkedList.head;
        Node slow = linkedList.head;

        do {
            if(fast.next == null || fast.next.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while(fast != slow);
        return true;
    }
}
