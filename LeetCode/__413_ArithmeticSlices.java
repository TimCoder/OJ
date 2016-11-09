package tim.leetcode;

public class __413_ArithmeticSlices {

    /*
     * Time : O(N), Space : O(1). 
     */
    public int numberOfArithmeticSlices(int[] A) {

        if (A == null || A.length < 3) {
            return 0;
        }

        int N = A.length;
        int cur = 0;
        int res = 0;
        for (int i = 2; i < N; ++i) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                ++cur;
                res += cur;
            } else {
                cur = 0;
            }
        }

        return res;

    }

    /*
     * Time : O(N), Space : O(1). 
     */
    /*
    public int numberOfArithmeticSlices(int[] A) {

        if (A == null || A.length < 3) {
            return 0;
        }

        int N = A.length;
        int res = 0;
        int cur = 2;
        int diff = A[1] - A[0];
        for (int i = 2; i < N; ++i) {
            int curDiff = A[i] - A[i - 1];
            if (curDiff == diff) {
                ++cur;
            } else {
                if (cur > 2) {
                    res += (cur - 2) * (cur - 1) / 2;
                }
                cur = 2;
                diff = curDiff;
            }
        }

        if (cur > 2) {
            res += (cur - 2) * (cur - 1) / 2;
        }

        return res;

    }
    */
}
