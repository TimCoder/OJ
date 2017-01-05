package tim.leetcode;

import java.util.HashMap;

public class __446_ArithmeticSlicesII_Subsequence {

    /*
     * Time : O(N ^ 2), Space : O(N ^ 2).
     */
    public int numberOfArithmeticSlices(int[] A) {

        int res = 0;
        int N = A.length;
        HashMap<Integer, Integer>[] map = new HashMap[N];

        for (int i = 0; i < N; ++i) { 
            map[i] = new HashMap(i);
            for (int j = 0; j < i; ++j) {
                //using long avoid overflow Integer range.
                long diff = (long)A[i] - A[j];
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }

                int d = (int)diff;
                //JDK 1.8
                /*
                int sumI = map[i].getOrDefault(d, 0);
                int sumJ = map[j].getOrDefault(d, 0);
                */
                int sumI = 0, sumJ = 0;
                if (map[i].containsKey(d)) {
                    sumI = map[i].get(d);
                }
                if (map[j].containsKey(d)) {
                    sumJ = map[j].get(d);
                }
                res += sumJ;
                map[i].put(d, sumI + sumJ + 1);
            }
        }

        return res;

    }

}
