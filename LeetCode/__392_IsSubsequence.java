package tim.leetcode;

public class __392_IsSubsequence {

    /*
     * Time : O(s.length() * String.indexOf), Space : O(1).
     * using time: 3 ms.
     */
    public boolean isSubsequence(String s, String t) {

        int j = 0;
        int i = 0;
        for ( ; i < s.length(); ++i) {
            char c = s.charAt(i);
            int pos = t.indexOf(c, j);
            if (pos == -1) {
                return false;
            } else {
                j = pos + 1; 
            }
            
        }

        return true;

    }
    

    /*
     * Time : O(t.length()), Space : O(1).
     * using time: 30 ms.
     */
    /*
    public boolean isSubsequence(String s, String t) {
        
        int M = s.length();
        int N = t.length();
        
        if (M == 0) {
            return true;
        }   

        if (M > N) {
            return false;
        }

        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            if (t.charAt(i) == s.charAt(cnt)) {
                ++cnt;
                if (cnt == M) {
                    return true;
                }
            }
        }

        return false;
    
    }
    */

    /*
     * Time : O(M * N), Space : O(N).
     * using time: 165ms.
     */
    /*
    public boolean isSubsequence(String s, String t) {
        
        int M = s.length();
        int N = t.length();
        if (M == 0) {
            return true;
        }   

        if (N == 0 || M > N) {
            return false;
        }   

        int[] dp = new int[N];
        int[] dpPre = new int[N];
        boolean findSI = false; 
        for (int j = 0; j < N; ++j) {
            if (!findSI) {
                if (s.charAt(0) == t.charAt(j)) {
                    dpPre[j] = 1; 
                    findSI = true;
                } else {
                    dpPre[j] = 0;
                }
            } else {
                dpPre[j] = dpPre[j - 1];
            }   
        }   
        if (dpPre[N - 1] < 1) {
            return false;
        }   
        findSI = false;

        for (int i = 1; i < M; ++i) {
            for (int j = 1; j < N; ++j) {
                dp[0] = dpPre[0];
                if (!findSI) { 
                    if (dpPre[j - 1] == i) {
                        if (s.charAt(i) == t.charAt(j)) { 
                            dp[j] = dp[j - 1] + 1;
                            findSI = true;
                        } else {
                            dp[j] = dpPre[j - 1];
                        }
                    } else {
                        dp[j] = dpPre[j];
                    }
                } else {
                    dp[j] = dp[j - 1];
                }
            }
            if (dp[N - 1] < i + 1) {
                return false;
            }
            findSI = false;
            int[] tmp = dp;
            dp = dpPre;
            dpPre = tmp;
        }

        return dpPre[N - 1] == M;

    }
    */
    
}
