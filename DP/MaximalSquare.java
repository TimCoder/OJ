public class MaximalSquare {
    
    public int maximalSquare(char[][] matrix) {
        
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int M = matrix.length;
        int N = matrix[0].length;
        // dp[i][j] means the maximal square that must has (i, j).
        int[] dpPre = new int[N];
        int[] dp = new int[N];
        int res = 0;
        for (int j = 0; j < N; ++j) {
            if (matrix[0][j] == '1') {
                dpPre[j] = 1;
                res = Math.max(dpPre[j], res);
            }
        }
        
        for (int i = 1; i < M; ++i) {
            dp[0] = matrix[i][0] == '1' ? 1 : 0;
            res = Math.max(dp[0], res);
            for (int j = 1; j < N; ++j) {
                if (matrix[i][j] == '1') {
                    dp[j] = Math.min(Math.min(dpPre[j - 1], dpPre[j]), dp[j - 1]) + 1;
                    res = Math.max(dp[j], res);
                } else {
                    dp[j] = 0;
                }
            }   
            int[] tmp = dp;
            dp = dpPre;
            dpPre = tmp;
        }   

        return res * res;

    }
}