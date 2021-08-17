package harish.twodimarray;

public class SpiralPrintingof2DArray {

    public static void main(String[] args) {
        int[][] a = {{2,3,4}, {5,6,7}, {8,9,0}};
        spiralPrinting(a, a.length, a[0].length);

    }

    public static void spiralPrinting(int[][] a, int rowLength , int columnLength) {

        int rowStart = 0;
        int rowEnd = rowLength;
        int columnStart = 0;
        int columnEnd = columnLength;

        int i;

        while(rowStart<rowEnd && columnStart<columnEnd) {
            for (i = columnStart; i < columnEnd; i++) {
                System.out.print(a[rowStart][i] + " ");
            }
            rowStart++;

            for (i = rowStart; i < rowEnd; i++) {
                System.out.print(a[i][columnEnd-1] + " ");
            }
            columnEnd--;

            for (i = columnEnd - 1; i >= columnStart; i--) {
                System.out.print(a[rowEnd-1][i] + " ");
            }
            rowEnd--;

            for (i = rowEnd - 1; i >= rowStart; i--) {
                System.out.print(a[i][columnStart] + " ");
            }
            columnStart++;
        }

    }
}
