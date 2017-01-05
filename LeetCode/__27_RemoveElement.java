package tim.leetcode;

public class __27_RemoveElement {

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] != val) {
                ++i;
            } else {
                nums[i] = nums[n - 1];
                --n;
            }
        }

        return n;

    }

}
