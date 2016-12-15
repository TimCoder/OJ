package tim.leetcode;

public class __66_PlusOne {

    public int[] plusOne(int[] digits) {

        int n = digits.length;
        int carry = 1;
        int sum;
        for (int i = n - 1; i >= 1; --i) {
            if (carry == 0) {
                return digits;
            }
            sum = digits[i] + carry;
            if (sum > 9) { 
                digits[i] = sum - 10; 
                carry = 1;
            } else {
                digits[i] = sum;
                carry = 0;
            }
        }
        sum = digits[0] + carry;
        if (sum > 9) {
            digits[0] = sum - 10;
            int[] res = new int[n + 1];
            res[0] = 1;
            for (int i = 1; i < n + 1; ++i) {
                res[i] = digits[i - 1];
            }
            return res;
        } else {
            digits[0] = sum;
            return digits;
        }
        
    }

}
