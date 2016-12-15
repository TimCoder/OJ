package tim.leetcode;

import java.util.HashMap;
import java.util.Map;

public class __414_ThirdMaximumNumber {

    public int thirdMax(int[] nums) {

        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int x : nums) {
            if (x > first) {
                third = second;
                second = first;
                first = x;
            } else if (x == first) {
                continue;
            } else if (x > second) {
                third = second;
                second = x; 
            } else if (x == second) {
                continue;
            } else if (x > third) {
                third = x;
            }
        }

        return third == Long.MIN_VALUE ? (int)first : (int)third;

    }
    /*
    public int thirdMax(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            if (!map.containsKey(1)) { 
                if (nums[i] > map.get(0)) {
                    map.put(1, map.get(0));
                    map.put(0, nums[i]); 
                } else if (nums[i] < map.get(0)) {
                    map.put(1, nums[i]);
                }
            } else if (!map.containsKey(2)) {
                if (nums[i] > map.get(0)) {
                    map.put(2, map.get(1));
                    map.put(1, map.get(0));
                    map.put(0, nums[i]);
                } else if (nums[i] < map.get(0) && nums[i] > map.get(1)) { 
                    map.put(2, map.get(1));
                    map.put(1, nums[i]);
                } else if (nums[i] < map.get(1)) {
                    map.put(2, nums[i]);
                }
            } else {
                if (nums[i] > map.get(0)) {
                    map.put(2, map.get(1));
                    map.put(1, map.get(0));
                    map.put(0, nums[i]);
                } else if (nums[i] < map.get(0) && nums[i] > map.get(1)) {
                    map.put(2, map.get(1));
                    map.put(1, nums[i]);
                } else if (nums[i] < map.get(1) && nums[i] > map.get(2)) {
                    map.put(2, nums[i]);
                }
            }
        }

        if (!map.containsKey(2)) {
            return map.get(0); 
        } else {
            return map.get(2);
        }

    }
    */

}
