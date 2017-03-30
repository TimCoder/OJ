public class NthUglyNumber {
    /*
    Here is a time efficient solution with O(n) extra space. The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
     because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:
     (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
     We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5. Then we use similar merge method as merge sort, to get every ugly number from the three subsequence. Every step we choose the smallest one, and move one step after.
     */
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1;
        }
        
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.min(Math.min(dp[t2] * 2, dp[t3] * 3), dp[t5] * 5);
            if (dp[i] == dp[t2] * 2) {
                ++t2;
            }
            if (dp[i] == dp[t3] * 3) {
                ++t3;
            }
            if (dp[i] == dp[t5] * 5) {
                ++t5;
            }
        }
        
        return dp[n - 1];
    }
}