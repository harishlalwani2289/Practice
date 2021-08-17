package harish;

public class AltimetricWaterProblem {

    public static void main(String[] args) {
        int[] array = {5,2,4,1,3,2};

        int currentElement = array[0];
        int waterBlocks = 0;
        for(int i=1;i<array.length;i++) {
            while(array[i] < currentElement) {
                waterBlocks = waterBlocks + (currentElement-array[i]);
                i++;
                if(i > array.length) {
                    System.out.println(0);
                }
            }
            currentElement = array[i];
        }
        System.out.println(waterBlocks);
    }
}
