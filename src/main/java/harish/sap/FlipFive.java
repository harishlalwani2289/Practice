package harish.sap;

import java.util.*;

public class FlipFive {

    // Directions for toggles (including self).
    final public static int[] DX = {0,-1,0,0,1};
    final public static int[] DY = {0,0,-1,1,0};

    // Dimensions for problem.
    final public static int R = 3;
    final public static int C = 3;

    public static void main(String[] args) {

        // Pre-process each solution - based on input directions, this is a one-to-one mapping,
        // no need to run BFS.
        int[] sol = new int[1<<(R*C)];
        for (int i=0; i<(1<<(R*C)); i++)
            sol[state(i)] = Integer.bitCount(i);

        // Process each case.
        Scanner stdin = new Scanner(System.in);
        int numCases = stdin.nextInt();
        for (int loop=0; loop<numCases; loop++) {

            // Read in grid.
            String s = stdin.next();
            for (int i=0; i<R-1; i++)
                s = s + stdin.next();

            // Output solution after conversion to bit mask (note - I flip this on vert and horiz axis, but that's okay.)
            System.out.println(sol[convert(s)]);
        }
    }

    // Returns binary value of s.
    public static int convert(String s) {

        int val = 0;

        // Go through each bit.
        for (int i=0; i<s.length(); i++) {

            // This always happens.
            val = (val << 1);

            // Just for bits that are on.
            if (s.charAt(i) == '*')
                val += 1;
        }

        return val;
    }

    public static int state(int bits) {

        int cur = 0;

        // Go through each bit that's on and flip each corresponding spot.
        for (int i=0; (1<<i)<=bits; i++)
            if ((bits & (1<<i)) != 0)
                cur = cur ^ flip(i);
        return cur;
    }

    public static int flip(int bit) {

        // Find bit.
        int myr = bit/C;
        int myc = bit%C;

        int res = 0;

        // Go through each spot, and add in mask for each one that's inbounds.
        for (int i=0; i<DX.length; i++)
            if (inbounds(myr+DX[i], myc+DY[i]))
                res += (1 << (C*(myr+DX[i]) + myc+DY[i]));

        return res;
    }

    public static boolean inbounds(int myr, int myc) {
        return myr >= 0 && myr < R && myc >= 0 && myc < C;
    }
}