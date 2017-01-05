package tim.leetcode;

import java.util.ArrayList;
import java.util.List;

public class __448_FindAllNumbersDisappearedinanArray {
    /*
     * Time : O(N), Space : O(1).
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        for (int i = 0; i < nums.length; ++i) {
            while(nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i]; 
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }

        return res;
    }

    /*
     * Time : O(N), Space : O(1).
     */
    /*
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) { 
            return res;
        }

        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = nums[index] > 0 ? -nums[index] : nums[index];
        }

        for (int i = 0; i < nums.length; ++i) { 
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }
    */

    /*
     * Time : O(N), Space : O(N).
     */
    /*
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) { 
            return res;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
        }
        for (int i = 1; i <= nums.length; ++i) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }

        return res;
    }
    */
}
