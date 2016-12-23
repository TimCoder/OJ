package tim.leetcode;

public class __75_SortColors {
    /*
     * Time : 1 traverse.
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zero = 0, second = n - 1; 
        int tmp;
        for (int i = 0; i <= second; ++i) {
            while (nums[i] == 2 && i < second) {
                tmp = nums[i];
                nums[i] = nums[second];
                nums[second] = tmp;
                --second;
            }

            while (nums[i] == 0 && i > zero) {
                tmp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = tmp;
                ++zero;
            }
        }
    }
    /*
     * Time : 2 traverse.
     */
    /*
    public void sortColors(int[] nums) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                ++a;
            } else if (nums[i] == 1) {
                ++b;
            } else {
                ++c;
            }
        }

        int i = 0; 
        while (a-- > 0) {
            nums[i++] = 0;
        }

        while (b-- > 0) {
            nums[i++] = 1;
        }

        while (c-- > 0) {
            nums[i++] = 2;
        }
    }
    */

}
