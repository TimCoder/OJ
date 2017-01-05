package tim.leetcode;

import java.util.HashMap;
import java.util.Map;

public class __219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                int diff = i - map.get(nums[i]);
                if (diff <= k) {
                    return true;
                }
            } 
            map.put(nums[i], i);
        }
        return false;
    }
}
