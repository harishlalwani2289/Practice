package practice.harish.linkedlist.core;

public class LinkedList {

    public Node head;

    public LinkedList() {
        this.head = null;
    }

    // Here we find if the linked list is empty
    public boolean isEmpty() {
        return (head==null);
    }

    // Inserts the new node at the head of Linked List or front
    public void insertFirst(int a) {
        Node node = new Node(a);
        node.next = head;
        head = node;
    }

    public Node insertAndReturnNode(int a) {
        Node node = new Node(a);
        node.next = head;
        head = node;
        return node;
    }

    // Inserts the new node at end of Linked List or rear
    public void insertLast(int a) {
        Node current = head;
        Node node = new Node(a);
        if (current == null) {
            head = node;
            return;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        node.next = null;
    }

    // Inserts the new node at end of Linked List or rear
    public Node insertLastAndReturnNode(int a) {
        Node current = head;
        Node node = new Node(a);
        if (current == null) {
            head = node;
            return head;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        node.next = null;
        return node;
    }

    // Deletes the node from head
    public void deleteFirst() {
        if(!isEmpty()) {
            head = head.next;
        }
    }

    // DisplayList by traversing from first to last
    public void displayList() {
        Node current = head;
        if(isEmpty()) System.out.println("List is Empty");

        while (current != null) {
            System.out.println(current.displayNode());
            current = current.next;
        }
    }




}
