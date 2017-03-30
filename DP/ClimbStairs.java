package tim.DP;

public class ClimbStairs {

    public int climbStairs(int n) {

        if (n <= 1) {
            return 1;
        }

        int[][] base = { {1, 1}, {1, 0} };
        int[][] tmp = matrixPower(base, n - 2);
        int[][] a = { {2, 1}, {0, 0} };
        int[][] res = multMatrix(a, tmp);
        return res[0][0];

    }

    public int[][] matrixPower(int[][] a, int n) { 

        int[][] res = new int[a.length][a[0].length];
        for (int i = 0; i < res.length; ++i) {
            res[i][i] = 1;
        }
            
        int[][] tmp = a;
        for ( ; n != 0; n >>= 1) {
            if ((n & 1) != 0) {
                res = multMatrix(res, tmp);
            }
            tmp = multMatrix(tmp, tmp);
        }

        return res;

    }

    public int[][] multMatrix(int[][] a, int[][] b) {

        int[][] res = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < b[0].length; ++j) {
                for (int k = 0; k < a[0].length; ++k) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return res;

    }
} 
