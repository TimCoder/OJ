package tim.targetOffer;

public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] a) {
        if (a == null || a.length == 0) {
            return Integer.MIN_VALUE;
        }

        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; ++i) {
            if (sum <= 0) {
                sum = a[i];
            } else {
                sum += a[i];
            }
            res = Math.max(sum, res);
        }

        return res;

    }
}
