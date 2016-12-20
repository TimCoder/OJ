package tim.leetcode;

public class __34_SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                while (l < m && nums[l] < target) {
                    ++l;
                }
                res[0] = l;
                while (m < r && nums[r] > target) {
                    --r;
                }
                res[1] = r;
                return res;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        res[0] = -1;
        res[1] = -1;
        return res; 
    }
}

