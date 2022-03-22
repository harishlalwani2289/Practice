package upgrad.dsaassignment;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(20);
        pq.add(30);
        pq.add(40);
        pq.add(50);
        pq.add(10);
        pq.add(60);

        // find 3 largest numbers
        for(int i=0;i<2;i++){
            pq.remove();
        }
        System.out.println(pq.remove());
    }
}
