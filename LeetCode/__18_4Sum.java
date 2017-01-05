package tim.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class __18_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; ++i) {
            target -= nums[i];
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < n - 2; ++j) {
                    if (j == i + 1 || j > i + 1 && nums[j] != nums[j - 1]) {
                        target -= nums[j];
                        int l = j + 1, r = n - 1;
                        while (l < r) {
                            if (nums[l] + nums[r] == target) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                                while (l < r && nums[l] == nums[l + 1]) ++l;
                                while (l < r && nums[r] == nums[r - 1]) --r;
                                ++l;
                                --r;
                            } else if (nums[l] + nums[r] < target) {
                                ++l;
                            } else {
                                --r;
                            }
                        }
                        target += nums[j];
                    }
                }
            }
            target += nums[i];
        }

        return res;
    }
}
