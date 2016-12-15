package tim.leetcode;

public class __26_RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
                
        int cnt = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[cnt] = nums[i];
                ++cnt;
            }
        }

        return cnt;

    }

}
