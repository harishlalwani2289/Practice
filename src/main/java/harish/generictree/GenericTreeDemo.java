package harish.generictree;

import java.util.ArrayList;

public class GenericTreeDemo {

    public static void main(String[] args) {
        GenericTree genericTree = new GenericTree();
        genericTree.root = new Node(10, new ArrayList<>());

        // Root children
        genericTree.root.children.add(new Node(20, new ArrayList<>()));
        genericTree.root.children.add(new Node(30, new ArrayList<>()));
        genericTree.root.children.add(new Node(40, new ArrayList<>()));


        // First child of root and inserting few nodes there
        genericTree.root.children.get(0).children.add(new Node(50, new ArrayList<>()));
        genericTree.root.children.get(0).children.add(new Node(60, new ArrayList<>()));

        // Second child of root and inserting few nodes there
        genericTree.root.children.get(1).children.add(new Node(70, new ArrayList<>()));
        genericTree.root.children.get(1).children.add(new Node(80, new ArrayList<>()));

        System.out.println(genericTree.root.children.get(0).data);

    }
}
