package tim.leetcode;

public class __15_3Sum {

    /*
     * Time : O(N ^ 2), Space : O(1).
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) { // skip same result
                getTwoSum(nums, i + 1, n - 1, -nums[i]);
            }
        }

        return res;
    }

    public void getTwoSum(int[] nums, int l, int r, int target) {
        while (l < r) {
            if (nums[l] + nums[r] < target) {
                ++l;
            } else if (nums[l] + nums[r] > target) {
                --r;
            } else {
                res.add(Arrays.asList(-target, nums[l], nums[r]));
                while (l < r && nums[l] == nums[l + 1]) ++l; // skip same result
                while (l < r && nums[r] == nums[r - 1]) --r; // skip same result
                ++l;
                --r;
            }
        }
    }

}
