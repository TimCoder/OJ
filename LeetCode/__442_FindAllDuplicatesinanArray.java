package tim.leetcode;

public class __442_FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                res.add(index + 1);
            }
        }
        return res;
    }
}
