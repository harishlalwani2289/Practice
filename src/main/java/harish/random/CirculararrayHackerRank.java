package harish.random;

import java.util.Arrays;
import java.util.List;

public class CirculararrayHackerRank {

    public static void main(String[] args) {
        int n =10;
        Integer[] endNode = {1,5,10,5};
        circularArray(n, Arrays.asList(endNode));

    }
    public static int circularArray(int n, List<Integer> endNode) {
        // Write your code here

        int[] count = new int[n];

        for (int i =0 ;i<endNode.size() - 1;i++) {
            int start = endNode.get(i);
            int end = endNode.get(i + 1);

            if (start <= end) {
                for ( int j = start;j <=end;j++)
                    count[j] ++;
            }
            else {
                for (int j= start;j<=n;j++)
                    count[j]++;
                for (int j=1;j<n;j++)
                    count[j]++;
            }
        }
        // Lets now find the most visited node

        int maxTimeVisited=0;
        int mostVisited=0;
        for (int i=0;i<=n;i++) {
            if (maxTimeVisited <count[i]) {
                maxTimeVisited= count[i];
                mostVisited = i;
            }
        }
        return mostVisited;

    }

}
