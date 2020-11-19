package random;

import java.io.*;

public class TestClass {
    static int minParkingSpaces(int[][] parkingStartEndTimes) {
        int minParkingSpace = 1;
        for(int i =0; i<parkingStartEndTimes.length -1 ; i++) {
                int startTime = parkingStartEndTimes[i][0];
                int endTime = parkingStartEndTimes[i][1];
                for(int j= i+1; j <parkingStartEndTimes.length;j++) {
                    if(parkingStartEndTimes[j][1] < startTime || parkingStartEndTimes[j][0] > endTime)
                        minParkingSpace++;
                    if(parkingStartEndTimes[j][0] >= startTime)
                        minParkingSpace--;
            }
        }
        return minParkingSpace;
    }

    // DO NOT MODIFY ANYTHING BELOW THIS LINE!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        int[][] parkingStartEndTimeList = new int[n][2];
        String[] parkingStartEndTimes = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
            for (int j = 0; j < parkingStartEndTime.length; j++) {
                parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
            }
        }

        int out = minParkingSpaces(parkingStartEndTimeList);
        System.out.println(out);

        wr.close();
        br.close();
    }
}