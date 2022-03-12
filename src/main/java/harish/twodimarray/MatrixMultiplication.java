package harish.twodimarray;

public class MatrixMultiplication {

  public static void main(String[] args) {
    int[][] a = {{1, 5, 7}, {5, 3, 9}, {7, 2, 5}};
    int[][] b = {{3, 6, 8}, {2, 8, 3}, {9, 1, 4}};
    int[][] c = new int[a.length][b[0].length];

    for (int i = 0; i < c.length; i++) {
      for (int j = 0; j < c[0].length; j++) {
        for (int k = 0; k < b.length; k++) {

          c[i][j] = c[i][j] + a[i][k]*b[k][j];

        }
      }
    }

    for (int[] ints : c) {
      for (int j = 0; j < c[0].length; j++) {
        System.out.print(ints[j] + " ");
      }
      System.out.println();
    }
  }

}
