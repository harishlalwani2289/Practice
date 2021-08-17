package harish.random;
/*
https://www.youtube.com/watch?v=5P84A0YCo_Y&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=10
 */
public class KthSymbolGrammar {
    public static void main(String[] args) {
        System.out.println(solve(4,6));
    }

    private static int solve(int n, int k) {

        if( n==1 && k==1) {
            return 0;
        }
        int mid = (int) Math.pow(2,n-1)/2;
        if(k <= mid)
            return solve(n-1,k);
        else
            return solve(n-1,k-mid)==1? 0: 1;
    }
}
