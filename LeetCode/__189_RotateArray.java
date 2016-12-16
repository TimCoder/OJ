package tim.leetcode;

public class __189_RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return ;
        }

        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] a, int l, int r) {
        while (l < r) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
            ++l;
            --r;
        }
    }

}
