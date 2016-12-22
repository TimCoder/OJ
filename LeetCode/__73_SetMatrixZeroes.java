package tim.leetcode;

public class __73_SetMatrixZeroes {

    /*
     * Time : O(M * N), Space : O(1).
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return ;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean fr = false;
        boolean fc = false;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        fr = true;
                    }
                    if (j == 0) {
                        fc = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int j = 1; j < n; ++j) {
            for (int i = 1; i < m; ++i) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (fr) {
            for (int j = 0; j < n; ++j) {
                matrix[0][j] = 0;
            }
        }

        if (fc) {
            for (int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }
    }

    /*
     * Time : O(M * N), Space : O(M + N).
     */
    /*
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return ;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    if (!row[i]) {
                        row[i] = true;
                    }
                    if (!col[j]) {
                        col[j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    */

}
