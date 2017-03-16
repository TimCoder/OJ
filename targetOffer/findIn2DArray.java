package tim.targetOffer;

public class  findIn2DArray {
    public boolean find(int target, int[][] a) {
        if (a == null || a.length == 0 || a[0].length == 0) {
            return false;
        }

        int m = a.length;
        int n = a[0].length;
        int r = n - 1;
        int t = 0;
        while (r >= 0 && t <= m - 1) {
            if (a[t][r] < target) {
                ++t;
            } else if (a[t][r] > target) {
                --r;
            } else {
                return true;
            }
        }

        return false;
    }
}
