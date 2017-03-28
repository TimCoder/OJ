package tim.interview;

import java.util.*;

public class netease3_multMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }
        
        int[] res = solve(a, n, k);
        
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                System.out.print(res[i]);
                continue;
            }
            System.out.print(" " + res[i]);
        }
    }
    
    public static int[] solve(int[] a, int n, int k) {
        int[] res = new int[n];
        int[][] b = new int[n][n];
        for (int i = 0; i < n; ++i) {
            b[i][i] = 1;
            b[i][(i+1) % n] = 1;
        }
        
        int[][] left = matrixPower(b, k);
        
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            for (int j = 0; j < n; ++j) {
                sum = (sum + left[i][j] * a[j]) % 100;
            }
            res[i] = sum;
        }

        return res;
    }
    
    public static int[][] matrixPower(int[][] b, int n) {
        int[][] res = new int[b.length][b[0].length];
        //把res设置成单位矩阵
        for (int i = 0; i < res.length; ++i) {
            res[i][i] = 1;
        }
        int[][] tmp = b;
        for ( ; n != 0; n >>= 1) {
            if ((n & 1) != 0) {
                res = multMatirx(res, tmp);
            }
            tmp = multMatirx(tmp, tmp);
        }
        
        return res;
    }

    public static int[][] multMatirx(int[][] a, int[][] b) {
        int[][] res = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < b[0].length; ++j) {
                for (int k = 0; k < b.length; ++k) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % 100;
                }
            }
        }
        
        return res;
    }
}