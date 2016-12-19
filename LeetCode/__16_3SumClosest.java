package tim.leetcode;

public class __16_3SumClosest {
    private int res;
    private int target;
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MIN_VALUE;
        }
        this.res = nums[0] + nums[1] + nums[2];
        this.target = target;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                if (findClosest(nums, i + 1, n - 1, nums[i])) {
                    return target;
                }
            }
        }
        return res;
    }

    public boolean findClosest(int a, int l, int r, int cur) {
        while (l < r) {
            int sum = cur + a[l] + a[r];
            if (sum == target) { 
                return true;
            } else if (sum < target) {
                ++l;
            } else {
                --r;
            }
            if (Math.abs(sum - target) < Math.abs(res - target)) {
                res = sum;
            }
        }
        return false;
    }
}
