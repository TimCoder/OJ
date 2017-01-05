package tim.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class __47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>();
        backtrack(res, tmp, used, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tmp, boolean[] used, int[] nums) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                tmp.add(nums[i]);
                backtrack(res, tmp, used, nums);
                used[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
