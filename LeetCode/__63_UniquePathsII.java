package tim.leetcode;

public class __63_UniquePathsII {

    /*
     * Time : O(m * n), Space : O(n). can be O(min(m, n)).
     */
    public int uniquePathsWithObstacles(int[][] a) {
        
        if (a == null || a.length == 0) { 
            return 0;
        }   
        
        if (a[0].length == 0) {
            return 1;
        }

        int m = a.length;
        int n = a[0].length;
        int[] cur = new int[n];
        cur[0] = 1;
        for (int i = 0; i < m; ++i) {
            if (a[i][0] == 1) {
                cur[0] = 0;  
            }
            for (int j = 1; j < n; ++j) {
                if (a[i][j] == 1) {
                    cur[j] = 0;
                } else {
                    cur[j] = cur[j] + cur[j - 1]; 
                }   
            }   
        }   

        return cur[n - 1]; 

    }

}
