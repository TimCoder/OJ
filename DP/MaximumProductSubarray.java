package tim.DP;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }   

        int N = nums.length;
        int maxDpPre = nums[0];
        int minDpPre = nums[0];
        int maxDp = 0;
        int minDp = 0;
        int res = nums[0];
        for (int i = 1; i < N; ++i) {
            maxDp = Math.max(Math.max(maxDpPre * nums[i], minDpPre * nums[i]), nums[i]);
            minDp = Math.min(Math.min(maxDpPre * nums[i], minDpPre * nums[i]), nums[i]);
            res = Math.max(maxDp, res);
            maxDpPre = maxDp;
            minDpPre = minDp;
        }   
            
        return res;

    }
    
}