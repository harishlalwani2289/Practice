package harish.generictree;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTreeDemo {

    public static void main(String[] args) {
        GenericTree genericTree = new GenericTree();
        int[] numbers = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,
                -1,-1,90,-1,-1,40,100,-1,-1,-1};
        genericTree.construct(numbers);

        // Display my generic tree
//        genericTree.display(genericTree.root);
        int sizeOfTree = genericTree.size(genericTree.root);
        System.out.println("Size of Tree :" + sizeOfTree);

    }
}
