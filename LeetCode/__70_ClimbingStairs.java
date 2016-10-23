package tim.leetcode;

public class __70_ClimbingStairs {


    
    public int climbStairs(int n) {

        if (n <= 1) {
            return 1;
        }   

        int a = 1;
        int b = 1;
        int c = a + b;
        for (int i = 2 ; i < n; ++i) {
            a = b;
            b = c;
            c = a + b;
        }   

        return c;

    }   




    /*
     * TLE, time O(2^n)
    */
    /*
    public int climbStairs(int n) {
        
        if (n == 0 || n == 1) {
            return 1;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    */

}
