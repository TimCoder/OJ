package tim.hihocoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class __1400 {

    /*
     * Test case : 1. 1 a 1 ab 2. 2 az 3 ab,ac,bc 3. 3 abz 3 ab,ac,bc 4. 4 abxz
     * 3 ab,ac,bx ,1
     */

    public static Set<String> set;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String s = in.next();
        int M = in.nextInt();
        set = new HashSet<>(M * 2);
        for (int i = 0; i < M; ++i) {
            String tmpS = in.next();
            set.add(tmpS);

            StringBuilder sb = new StringBuilder();
            sb.append(tmpS.charAt(1)).append(tmpS.charAt(0));
            set.add(sb.toString());
        }

        getMin(s, 0);

        System.out.println(min);

    }

    public static void getMin(String s, int cnt) {

        int len = s.length();
        if (len <= 1) {
            return;
        }

        int mid = len / 2;
        if (set.contains(s.substring(mid - 1, mid + 1))) {
            ++cnt;
            StringBuilder sb1 = new StringBuilder(s);
            StringBuilder sb2 = new StringBuilder(s);
            getMin(sb1.deleteCharAt(mid - 1).toString(), cnt);
            getMin(sb2.deleteCharAt(mid).toString(), cnt);
            return;
        }
        String sL = s.substring(0, mid);
        getMin(sL, cnt);
        String sR = s.substring(mid, len);
        getMin(sR, cnt);

        if (cnt < min) {
            min = cnt;
        }
    }

    /*
     * public static void getMin(String s, int cnt) {
     * 
     * int len = s.length(); for (int i = 1; i < len; ++i) { String cmp =
     * s.substring(i-1, i+1); if (set.contains(cmp)) { ++cnt; StringBuilder sb1
     * = new StringBuilder(s); StringBuilder sb2 = new StringBuilder(s);
     * getMin(sb1.deleteCharAt(i-1).toString(), cnt);
     * getMin(sb2.deleteCharAt(i).toString(), cnt); return ; } }
     * 
     * if (cnt < min) { min = cnt; }
     * 
     * }
     */
}
