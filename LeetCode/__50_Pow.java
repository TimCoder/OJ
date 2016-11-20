package tim.leetcode;

public class __50_Pow {

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1.0 / (myPow(x, Integer.MAX_VALUE) * x);
            } else {
                return 1.0 / myPow(x, -n);
            }
        }

        double res = 1.0;
        for ( ; n > 0; x *=x, n >>= 1) {
            if ((n & 1) > 0) {
                res *= x;
            }
        }

        return res;

    }

}
