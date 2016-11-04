package tim.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class  __354_RussianDollEnvelopes {

    class Doll {
        int w;
        int h;
        Doll(int width, int height) {
            this.w = width;
            this.h = height;
        }
    }

    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        int N = envelopes.length;
        Doll[] doll = new Doll[N];
        for (int i = 0; i < N; ++i) {
            doll[i] = new Doll(envelopes[i][0], envelopes[i][1]);
        }

        Arrays.sort(doll, new DollComparator());
        int[] dp = new int[N];

        //left and right are the border in dp.
        int left = 0;
        int right = 0; 
        int max = 1;
        for (int i = 1; i < N; ++i) {
            int l = left;
            int r = right;
            while(l <= r) {
                int m = l + (r - l) / 2;
                if (doll[i].h > dp[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(l, right);
            dp[l] = doll[i].h;
            max = Math.max(l + 1, max);
        }

        return max;

    }

    public class DollComparator implements Comparator<Doll> {

        @Override
        public int compare(Doll d1, Doll d2) {
            if (d1.w == d2.w) {
                if (d1.h == d2.h) {
                    return 0;
                } else if (d1.h > d2.h) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (d1.w < d2.w) {
                return -1;
            } else {
                return 1;
            }

        }

    }

}
