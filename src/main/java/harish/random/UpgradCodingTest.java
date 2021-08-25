package harish.random;


import harish.linkedlist.core.LinkedList;
import harish.linkedlist.core.Node;

public class UpgradCodingTest {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

    }

    public boolean findLoop(Node head) {

        Node first = head;
        Node second = head;

        while(second.next != null && second.next.next !=null) {
            first = first.next;
            second = second.next.next;
            if(first == second)
                return true;
        }
        return false;

    }

}
