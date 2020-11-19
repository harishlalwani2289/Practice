package com.harish.circularlinkedlist;

import com.harish.circularlinkedlist.core.CircularLinkedList;

public class CirclularLinkedListApp {

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        circularLinkedList.insert(19);
        circularLinkedList.insert(29);
        circularLinkedList.insert(39);
        circularLinkedList.insert(49);
        circularLinkedList.insert(59);

        circularLinkedList.displayList();
    }
}
