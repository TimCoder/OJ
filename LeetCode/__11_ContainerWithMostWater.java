package tim.leetcode;

public class __11_ContainerWithMostWater {
    public int maxArea(int[] h) {
        if (h == null || h.length < 2) {
            return 0;
        }

        int l = 0, r = h.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max((r - l) * Math.min(h[l], h[r]), res);
            if (h[l] < h[r]) {
                ++l;
            } else {
                --r;
            }
        }

        return res;
    }
}
