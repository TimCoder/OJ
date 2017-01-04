package tim.leetcode;

public class __90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);// must sort!
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
        res.add(new ArrayList<Integer>(tmp));
        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i - 1]) { 
                continue;
            }
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
