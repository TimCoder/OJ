package tim.leetcode;

public class __268_MissingNumber {
    /*
     * a ^ b ^ b = a
     * o ^ a = a
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        int i;
        for (i = 0; i < n; ++i) {
            xor ^= i ^ nums[i];
        }
        return xor ^ i;
    }

    /*
     * Add all numbers. 
     */
    /*
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }

        int all = n * (n + 1) / 2;
        return all - sum;
    }
    */
}
