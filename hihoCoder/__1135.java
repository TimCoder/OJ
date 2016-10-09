package tim.hihocoder;

import java.util.Arrays;
import java.util.Scanner;

public class __1135 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        String str = in.next();
        int[] a = new int[3];
        a[0] = x;
        a[1] = y;
        a[2] = z;
        Arrays.sort(a);
        int[] b = new int[3];

        int cR = 0;
        int cY = 0;
        int cB = 0;
        int cur = 0;
        int max = 0;
        for (int i =0; i < str.length(); ++i) {
            if (str.charAt(i) == 'R') {
                ++cR;
            } else if (str.charAt(i) == 'Y') {
                ++cY;
            } else if (str.charAt(i) == 'B') {
                ++cB;
            }
            ++cur;
            if (max < cur) {
                max = cur;
            }
            b[0] = Math.abs(cR-cY);
            b[1] = Math.abs(cY-cB);
            b[2] = Math.abs(cB-cR);
            Arrays.sort(b);
            if (a[0] == b[0] && a[1] == b[1] && a[2] == b[2]) {
                cR = 0;
                cY = 0;
                cB = 0;
                cur = 0;
            }
        }
        System.out.println(max);
    }

}


