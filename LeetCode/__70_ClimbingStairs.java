package tim.leetcode;

import java.util.Scanner;

public class __70_ClimbingStairs {
    
    /*
     * time O(n)
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(climbStairs(N));
        
    }

    public static class Matrix2x2 {

        int m00;
        int m01;
        int m10;
        int m11;

        Matrix2x2(int x00, int x01, int x10, int x11) {
            this.m00 = x00;
            this.m01 = x01;
            this.m10 = x10;
            this.m11 = x11;
        }

    }

    public static int climbStairs(int n) {

        if (n <= 1) {
            return 1;
        }

        Matrix2x2 m = matrixPower(n);

        return m.m00;

    }

    public static Matrix2x2 matrixPower(int n) { 

        Matrix2x2 m = new Matrix2x2(1, 1, 1, 0);

        if (n == 1) {
            return m;
        } else if (n % 2 == 0) {
            m = matrixPower(n/2);
            m = multiplyMatrix(m, m);
        } else if (n % 2 == 1) {
            m = matrixPower((n-1)/2);
            m = multiplyMatrix(m, m);
            m = multiplyMatrix(m, new Matrix2x2(1, 1, 1, 0));
        }

        return m;

    }

    public static Matrix2x2 multiplyMatrix(Matrix2x2 m1, Matrix2x2 m2) {

        Matrix2x2 m = new Matrix2x2(1, 1, 1, 0);
        m.m00 = m1.m00 * m2.m00 + m1.m01 * m2.m10;
        m.m01 = m1.m00 * m2.m01 + m1.m01 * m2.m11;
        m.m10 = m1.m10 * m2.m00 + m1.m11 * m2.m10;
        m.m11 = m1.m10 * m2.m01 + m1.m11 * m2.m11;

        return m;

    }
    
    /*
     * time O(n)
     */
    /*
    public int climbStairs(int n) {

        if (n <= 1) {
            return 1;
        }   

        int a = 1;
        int b = 1;
        int c = a + b;
        for (int i = 2 ; i < n; ++i) {
            a = b;
            b = c;
            c = a + b;
        }   

        return c;

    }  
    */ 

    /*
     * TLE, time O(2^n)
    */
    /*
    public int climbStairs(int n) {
        
        if (n == 0 || n == 1) {
            return 1;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    */

}
