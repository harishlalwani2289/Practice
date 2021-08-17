package harish.linkedlist;

import harish.linkedlist.core.LinkedList;
import harish.linkedlist.core.Node;

public class Upgrad {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node node1 = linkedList.insertAndReturnNode(5);
        linkedList.insertAndReturnNode(4);
        linkedList.insertAndReturnNode(3);
        Node node2 = linkedList.insertAndReturnNode(2);
        linkedList.insertAndReturnNode(1);
//        node1.next = node2;

        boolean loopPresent = detectLoopInLinkedList(linkedList);
        System.out.println("Loop present :" + loopPresent);
    }

    private static boolean detectLoopInLinkedList(LinkedList linkedList) {

        Node fast = linkedList.head.next;
        Node slow = linkedList.head;

        while (fast != null || slow != null) {
            if(fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
