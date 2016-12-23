package tim.leetcode;

public class __80_RemoveDuplicates {
    /*
     * Time : O(N), Space : O(1).
     * Expend 2 to k.
     */
    public int removeDuplicates(int[] nums) {
        int k = 2;

        if (nums == null || nums.length == 0) { 
            return 0;
        }

        int cnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (cnt < k || nums[i] > nums[cnt - k]) {   
                nums[cnt++] = nums[i];
            }
        }

        return cnt;
    }

    /*
     * Time : O(N), Space : O(1), using flag.
     */
    /*
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) { 
            return 0;
        }

        int cnt = 1;
        boolean dup = false;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                if (!dup) {
                    nums[cnt++] = nums[i];
                    dup = true;
                }
            } else {
                nums[cnt++] = nums[i];
                dup = false;
            }
        }

        return cnt;
    }
    */
}
