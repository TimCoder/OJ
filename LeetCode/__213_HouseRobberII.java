package tim.leetcode;

public class __213_HouseRobberII {
    
    /*
     * time O(N), space O(1)
    */
    public int rob(int[] nums) {

        int N = nums.length;
        if (N < 1) {
            return 0;
        }
        if (N == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        if (N == 3) {
            return Math.max(Math.max(nums[0], nums[1]),nums[2]);
        }

        int robStart = nums[0] + robHelper(nums, 2, N, true);
        int robWithoutStart = robHelper(nums, 1, N, false);
    
        return Math.max(robStart, robWithoutStart);

    }

    public int robHelper(int[] nums, int start, int N, boolean isRobStart) {

        if (start >= N) {
            return 0;
        }

        int preRob = nums[start], rob = preRob;
        int preSkip = 0, skip;
        for (int i = start + 1; i < N; ++i) {
            if (i == N - 1 && isRobStart) {
                rob = preRob;
                skip = preSkip;
                break;
            }
            rob = Math.max(preSkip + nums[i], preRob);
            skip = preRob; // same to Math.max(preRob, preSkip) 

            preRob = rob;
            preSkip = skip;
        }

        return rob;
    }

}
