package tim.leetcode;

public class __59_SpiralMatrixII {

    private int[][] res;

    private int cnt = 1;

    public int[][] generateMatrix(int n) {
        res = new int[n][n];
        int t = 0, b = n - 1;
        int l = 0, r = n - 1;
        while (l <= r) {
            generate(t, b, l, r);
            ++t;
            --b;
            ++l;
            --r;
        }

        return res;
    }

    public void generate(int t, int b, int l, int r) {
        if (l == r) {
            res[t][b] = cnt++;
            return ;
        }

        for (int i = l; i < r; ++i) {
            res[t][i] = cnt++;
        }

        for (int i = t; i < b; ++i) {
            res[i][r] = cnt++;
        }

        for (int i = r; i > l; --i) {
            res[b][i] = cnt++;
        }

        for (int i = b; i > t; --i) {
            res[i][l] = cnt++;
        }
    }
}
