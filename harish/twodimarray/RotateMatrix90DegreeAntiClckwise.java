package practice.harish.arrays.twodimarray;

public class RotateMatrix90DegreeAntiClckwise {

    public static void main(String[] args) {
        int[][] array = {{1,2,3,10}, {4,5,6,11}, {7,8,9,12}};
        int[][] newArray = new int[4][3];

        int oi;
        int oj;
        int ni;
        int nj;

        // for each row in original array
        // we will fill columns in new array
        for (oi = 0, nj = 0; oi< array.length && nj < newArray.length ; oi++, nj++) {

            for(oj=0, ni = array[0].length -1; oj < array[0].length && ni >= 0 ; oj++, ni--){
                newArray[ni][nj] = array[oi][oj];
            }
        }

        for(int i = 0; i< newArray.length ;i++) {
            System.out.println();
            for(int j=0;j<newArray[0].length;j++) {
                System.out.print(newArray[i][j] + " ");
            }
        }



    }
}
