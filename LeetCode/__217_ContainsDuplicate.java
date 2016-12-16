package tim.leetcode;   

public class __217_ContainsDuplicate {
    /*
     * Time : O(N * log N), Sapce : O(1).
     */
    /*
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
    */

    /*
     * Time : O(N * log N), Sapce : O(1).
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}
