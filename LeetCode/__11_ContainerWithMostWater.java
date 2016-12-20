package tim.leetcode;

public class __11_ContainerWithMostWater {
    public int maxArea(int[] h) {
        if (h == null || h.length < 2) {
            return 0;
        }

        int l = 0, r = h.length - 1;
        boolean isLeftMin; 
        int min;
        int res;
        if (h[l] < h[r]) {
            isLeftMin = true;
            min = h[l];
            res = (r - l) * min;
            ++l;
        } else {
            isLeftMin = false;
            min = h[r];
            res = (r - l) * min;
            --r;
        }
        while (l < r) {
            if (isLeftMin) {
                if (h[l] < min) {
                    ++l;
                } else {
                    if (h[l] < h[r]) {
                        res = Math.max((r - l) * h[l], res); 
                        ++l;
                    } else {
                        res = Math.max((r - l) * h[r], res); 
                        isLeftMin = false;
                        --r;
                    }
                }
            } else {
                if (h[r] < min) {
                    --r;
                } else {
                    if (h[l] < h[r]) {
                        res = Math.max((r - l) * h[l], res); 
                        isLeftMin = true;
                        ++l;
                    } else {
                        res = Math.max((r - l) * h[r], res); 
                        --r;
                    }
                }
            }
        }

        return res;
    }
}
