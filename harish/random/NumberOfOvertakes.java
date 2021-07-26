package practice.harish.random;


import java.util.Scanner;

class TestClass {

    public static void main(String args[]) throws Exception {
        Scanner r = new Scanner(System.in);
        int N = r.nextInt();
        int vel[] = new int[N];
        int pos[] = new int[N];
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) vel[i] = r.nextInt();

        for (int i = 0; i < N; i++) {
            pos[i] = r.nextInt();
            arr[pos[i] - 1] = vel[i];
            //System.out.println(arr[i]);
        }

        System.out.println(mergeSort(0, N - 1, arr));
        //for(int i : arr)
        //System.out.println(i);
    }

    public static long mergeSort(int strt, int end, int[] arr) {
        if (strt >= end) return 0;

        int mid = (end + strt) / 2;

        long l = mergeSort(strt, mid, arr);
        long r = mergeSort(mid + 1, end, arr);

        long m = merge(strt, mid, end, arr);

        return l + r + m;
    }


    public static long merge(int strt, int mid, int end, int[] arr) {
        int temp[] = new int[end - strt + 1];
        // System.out.println("strt "+strt +"end "+end+ "mid "+mid);
        int i = strt;
        int j = mid + 1;
        int index = 0;
        long inver = 0l;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
                // System.out.println(mid + " " + i +" "+j);
                inver += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= end) temp[index++] = arr[j++];

        for (int k = 0; k < temp.length; k++) {
            // System.out.println(temp[k]);
            arr[strt++] = temp[k];
        }
        return inver;
    }
}