package tim.leetcode;

public class __198_HouseRobber {

    /*
     * time O(N), space O(1)
    */
    public int rob(int[] nums) {

        int N = nums.length;
        if (N < 1) {
            return 0;
        }
        int preRob = nums[0], rob = preRob;
        int preSkip = 0, skip;
        for (int i = 1; i < N; ++i) {
            rob = Math.max(preSkip + nums[i], preRob);
            skip = preRob; // same to Math.max(preRob, preSkip) 

            preRob = rob;
            preSkip = skip;
        }

        return rob;

    }

    /*
     * time O(N), space O(N)
    */
    /*
    public int rob(int[] nums) {
    
        int N = nums.length;
        if (N < 1) {
            return 0;
        }
        
        int[] rob = new int[N];
        int[] skip = new int[N];
        rob[0] = nums[0];
        skip[0] = 0;
        for (int i = 1; i < N; ++i) {
            rob[i] = Math.max(skip[i - 1] + nums[i], rob[i - 1]);    
            skip[i] = Math.max(rob[i - 1], skip[i - 1]);
        }   
    
        return Math.max(rob[N - 1], skip[N - 1]);

    }   
    */
}
