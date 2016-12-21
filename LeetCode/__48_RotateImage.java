package tim.leetcode;

public class __48_RotateImage {
    public void rotate(int[][] matrix) {
        int l = 0, r = matrix.length - 1;
        while (l < r) {
            rotateHelper(matrix, l, r, l, r); 
            ++l;
            --r;
        }
    }

    public void rotateHelper(int[][] m, int T, int B, int L, int R) {
        int tmp;
        for (int i = 0; i < R - L; ++i) {
            tmp = m[T][L + i];
            m[T][L + i] = m[B - i][L];
            m[B - i][L] = m[B][R - i];
            m[B][R - i] = m[T + i][R];
            m[T + i][R] = tmp;
        }
    }
}
