package tim.leetcode;

public class __169_MajorityElement {

    public int majorityElement(int[] nums) {
                
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (cnt == 0) { 
                res = nums[i];
                ++cnt;
                continue;
            }

            if (nums[i] != res) {
                --cnt;
            } else {
                ++cnt;
            }
        }

        return res;

    }

}
