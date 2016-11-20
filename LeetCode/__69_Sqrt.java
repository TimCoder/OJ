package tim.leetcode;

public class __69_Sqrt {
    /*
     * TLE.
     * Time : O(n), Space : O(1).
     * using time: 3 ms.
     */
    public int mySqrt(int x) {

        int left = 1, right = x;

        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
    }

    /*
     * TLE.
     * Time : O(n), Space : O(1).
     */
    /*
    public int mySqrt(int x) {
        
        if (x <= 0) {
            return x;
        }   

        int cnt = 0;
        //必须用tmp，不能改变x的值。
        int tmp = x;
        for ( ; tmp > 0; tmp >>= 1) {
            ++cnt;
        }
        
        int i = (int)Math.pow(2, (cnt - 1) / 2);
        if (i * i == x) {
            return i;
        }
        
        while (i * i < x) {
            ++i;
            if (i * i == x) {
                return i;
            }
        }
        
        return i - 1;
        
    }
    */

    /*
     * TLE.
     * Time : O(n), Space : O(1).
     */
    /*
    public int mySqrt(int x) {
        
        if (x <= 0) {
            return x;
        }   

        int preRes = 0;
        int res = preRes;  
        for (int i = 1; i <= x; ++i) {
            if ((preRes + 1) * (preRes + 1) <= i) {
                res = preRes + 1; 
                preRes = res;
            } 
        }   

        return res;

    }
    */

}
