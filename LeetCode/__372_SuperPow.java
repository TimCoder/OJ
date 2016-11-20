package tim.leetcode;

public class __372_SuperPow {

    /*
     * Time : O(b.length), Space : O(b.length).
     * using time : 11 ms.
     *
     * Suppose f(a, b) calculates a^b % k; Then translate above formula to using f :
     * f(a,1234567) = f(a, 1234560) * f(a, 7) % k = f(f(a, 123456),10) * f(a,7)%k;
     */
    private base = 1337;

    public int superPow(int a, int[] b) {

        if (b == null || b.length == 0) {
            return 1;
        }

        return superPow(a, b, b.length);

    }

    private int superPow(int a, int[] b, int length) {

        if (length == 1) {
            return powMod(a, b[0]);
        }

        return powMod(superPow(a, b, length - 1), 10) * powMod(a, b[length - 1]) % base;

    }

    private int powMod(int a, int n) {

        a %= base;
        int res = 1;
        for (int i = 0; i < n; ++i) {
            res = (res * a) % base;
        }

        return res;
    }

}
