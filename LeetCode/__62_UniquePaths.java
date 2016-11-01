package tim.leetcode;

public class __62_UniquePaths {

    /*
     * time O(m * n), space: O(min(m,n)).
     */
    public int uniquePaths(int m, int n) {
        
        if (m > n) {
            return uniquePaths(n, m);
        }
        
        if (m == 1 || n == 1) {
            return 1;
        }
        
        if (m == 2) {
            return n;
        }
            
        if (n == 2) {
            return m;
        } 
        
        //cur line
        int[] cur = new int[n];

        for (int j = 0; j < n; ++j) { 
            cur[j] = 1;
        }   

        for (int i = 1; i < m; ++i) { 
            for (int j = 1; j < n; ++j) {
                cur[j] = cur[j - 1] + cur[j];
            }   
        }   

        return cur[n - 1]; 

    }
    
}
