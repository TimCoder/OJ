package tim.leetcode;

public class __1_TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) { 
            int complement = target - nums[i];
            if (map.contains(complement)) {
                res[0] = map.get(complement);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }

        return res;
                
    }

}
