package harish.twodimarray;

/*
    Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
    Each cell of the matrix represents a cost to traverse through that cell.
    The total cost of a path to reach (m, n) is the sum of all the costs on that path (including both source and destination).
     You can only traverse down, right and diagonally lower cells from a given cell, i.e.,
     from a given cell (i, j), cells (i+1, j), (i, j+1), and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.
 */
public class MinimumCostPath {
    public static void main(String[] args) {
        int cost[][] = { {1, 2, 3},
                         {4, 8, 2},
                         {1, 5, 3} };

        // Now we have thecost matrix and we have understod that we need a dynamic problem solution for this
        // Overlapping sub-problems and optimal substructures
        System.out.println(minCost(cost,2,2));
    }

    public static int minCost(int[][] cost, int m, int n) {

        // We will construct a total cost matrix where each element
        // wil denote the the minimum cost required to reach there
        int[][] tc = new int[m+1][n+1];
        tc[0][0] = cost[0][0];
        // Initialize the first row
        for(int i=1;i<=m;i++) {
            tc[i][0] = tc[i-1][0] + cost[i][0];
        }

        // Initialize the first column
        for(int i=1;i<=n;i++) {
            tc[0][i] = tc[i-1][0] + cost[0][i];
        }

        // Now that we have initialized the first row and column
        // Rest values of matrix will be decided basis on where to come from

        for (int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                tc[i][j] = cost[i][j] + min(tc[i-1][j-1], tc[i-1][j], tc[i][j-1]);
            }
        }
        return tc[m][n];
    }

    private static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }
}
