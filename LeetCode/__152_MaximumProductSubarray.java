package tim.leetcode;

public class __152_MaximumProductSubarray {

    /*
     * Time: O(N), Space: O(1).
     */
    public int maxProduct(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }   

        int N = nums.length;
        int maxHerePre = nums[0];
        int minHerePre = nums[0];
        int max = nums[0];
        //👿 maxHere means the max product that end with i and nums[i] must be included.
        int maxHere, minHere;
        for (int i = 1; i < N; ++i) {
            maxHere = Math.max(Math.max(maxHerePre * nums[i], minHerePre * nums[i]), nums[i]);
            minHere = Math.min(Math.min(maxHerePre * nums[i], minHerePre * nums[i]), nums[i]);
            max = Math.max(maxHere, max);
            maxHerePre = maxHere;
            minHerePre = minHere;
        }   
            
        return max;

    }
    /*
     * WA.
     * 169 / 183 test cases passed. 
     */
    /*
    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int N = nums.length;
        int[] dp = new int[N];
        int[] dpPos = new int[N];
        int max = nums[0];
        boolean isNeg = false;
        if (nums[0] == 0) {
            dp[0] = 1;
            dpPos[0] = 1;
        } else if (nums[0] > 0) {
            dp[0] = nums[0];
            dpPos[0] = nums[0];
        } else { 
            dp[0] = nums[0];
            dpPos[0] = 1;
            isNeg = true;
        }   
        for (int i = 1; i < N; ++i) {
            if (nums[i] == 0) {
                dp[i] = 1;
                dpPos[i] = 1;
                max = Math.max(0, max);
                isNeg = false;
            } else if (nums[i] > 0) {
                dp[i] = nums[i] * dp[i - 1]; 
                dpPos[i] = nums[i] * dpPos[i - 1]; 
                if (isNeg) {
                    max = Math.max(dpPos[i], max);
                } else {
                    max = Math.max(dp[i], max);
                }   
            } else {
                dp[i] = nums[i] * dp[i - 1]; 
                if (isNeg) {
                    dpPos[i] = dp[i];
                    max = Math.max(dp[i], max);
                } else {
                    dpPos[i] = 1;
                }
                isNeg = !isNeg;
            }
            // System.out.print(max + " ");
        }

        return max;

    }
    */

}
