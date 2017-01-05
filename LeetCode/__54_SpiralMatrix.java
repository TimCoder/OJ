package tim.leetcode;

import java.util.ArrayList;
import java.util.List;

public class __54_SpiralMatrix {

    List<Integer> res = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int t = 0, b = m - 1;
        int l = 0, r = n - 1;
        while (l <= r && t <= b) {
            spiral(matrix, t, b, l, r);
            ++l;
            --r;
            ++t;
            --b;
        }

        return res;
    }

    public void spiral(int[][] m, int t, int b, int l, int r) {
        if (t == b && l == r && t == l) {
            res.add(m[t][l]);
            return ;
        }

        if (t == b && l != r) {
            for (int i = l; i <= r; ++i) {
                res.add(m[t][i]);
            }
            return ;
        }

        if (t != b && l == r) {
            for (int i = t; i <= b; ++i) {
                res.add(m[i][l]);
            }
            return ;
        }

        for (int i = l; i < r; ++i) {
            res.add(m[t][i]);
        }

        for (int i = t; i < b; ++i) {
            res.add(m[i][r]);
        }

        for (int i = r; i > l; --i) {
            res.add(m[b][i]);
        }

        for (int i = b; i > t; --i) {
            res.add(m[i][l]);
        }
    }
}
