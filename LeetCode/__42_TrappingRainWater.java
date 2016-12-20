package tim.leetcode;

public class __42_TrappingRainWater {
    public int maxArea(int[] h) {
        if (h == null || h.length < 3) {
            return 0;
        }

        int res = 0;
        int l = 0, r = h.length - 1;
        int minHeight;
        boolean isLeftMin;
        if (h[l] < h[r]) {
            minHeight = h[l];
            isLeftMin = true;
            ++l;
        } else {
            minHeight = h[r];
            isLeftMin = false;
            --r;
        }
        while (l < r) {
            if (isLeftMin) {
                if (h[l] < minHeight) {
                    res += minHeight - h[l];
                    ++l;
                } else { 
                    if (h[l] < h[r]) {
                        minHeight = h[l];
                        ++l;
                    } else {
                        minHeight = h[r];
                        isLeftMin = false;
                        --r;
                    }
                }
            } else {
                if (h[r] < minHeight) {
                    res += minHeight - h[r];
                    --r;
                } else {
                    if (h[l] < h[r]) {
                        minHeight = h[l];
                        isLeftMin = true;
                        ++l;
                    } else {
                        minHeight = h[r];
                        --r;
                    }
                }
            }
        }

        return res;
    }
}
