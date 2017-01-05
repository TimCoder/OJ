package tim.leetcode;

public class __283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j] = nums[i]; 
                ++j;
            }
        }

        while (j < nums.length) {
            nums[j] = 0;
            ++j;
        }
    }
}
