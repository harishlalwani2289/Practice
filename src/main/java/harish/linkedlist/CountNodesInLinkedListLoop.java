package harish.linkedlist;

import harish.linkedlist.core.LinkedList;
import harish.linkedlist.core.Node;

public class CountNodesInLinkedListLoop {

    public static void main(String arg[]) {

        LinkedList loopedLinkedList = new LinkedList();
        loopedLinkedList.insertFirst(70);
        loopedLinkedList.head.next = new Node(60);
        loopedLinkedList.head.next.next = new Node(50);
        loopedLinkedList.head.next.next.next = new Node(40);
        loopedLinkedList.head.next.next.next.next = new Node(30);
        loopedLinkedList.head.next.next.next.next.next = new Node(20);
        loopedLinkedList.head.next.next.next.next.next.next = loopedLinkedList.head.next;

        // Lets find the count of nodes in circle or loop
        System.out.println("Total number of nodes in loop are " + countNodesInLoop(loopedLinkedList));
    }

    private static Integer countNodesInLoop(LinkedList loopedLinkedList) {

        Node slowPointer = loopedLinkedList.head;
        Node fastPointer = loopedLinkedList.head;

        while(slowPointer != null && fastPointer != null && fastPointer.next != null)
        {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer) {
                System.out.println("Provided linked list consist a loop");
                return countNodes(fastPointer);
            }
        }
        System.out.println("There is no loop in provided linked list");
        return 0;
    }

    public static Integer countNodes(Node node) {

        Node temp = node;
        Integer count = 1;

        while (temp.next != node) {
            count++;
            temp = temp.next;
        }

        return  count;
    }

}
