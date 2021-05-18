package practice.harish.circularlinkedlist.core;

public class CircularLinkedList {

    public Node head;

    public CircularLinkedList() {
        this.head = null;
    }

    // Here we find if the linked list is empty
    public boolean isEmpty() {
        return (head==null);
    }

    // Inserts the new node at the head of Circular Linked List or front
    public void insert(int a) {
        Node node = new Node(a);
        node.next = head;
        Node temp = head;

        if(head != null) {
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = node;
        }
        else {
            node.next = node;
        }
        head = node;
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

        do {
            System.out.println(current.displayNode());
            current = current.next;
        }while (current != head);
    }
}
