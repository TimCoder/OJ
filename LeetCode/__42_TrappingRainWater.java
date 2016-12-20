package tim.leetcode;

public class __42_TrappingRainWater {
    public int maxArea(int[] h) {
        if (h == null || h.length < 3) {
            return 0;
        }

        int res = 0;
        int l = 0, r = h.length - 1;
        int min = Math.min(h[l], h[r]);
        if (h[l] < h[r]) {
            ++l;
        } else {
            --r;
        }
        while (l < r) {
            int curMin = Math.min(h[l], h[r]);
            res += min > curMin ? min - curMin : 0;
            min = Math.max(curMin, min);
            if (h[l] < h[r]) {
                ++l;
            } else {
                --r;
            }
        }

        return res;
    }
}
