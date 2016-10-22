package tim.hihocoder;

import java.util.Scanner;
import java.util.Stack;

public class __1399 {
    
    /*
     * Test case :
     *          1. 1 ; o/e.          1
     *          2. 2 ; o, o.         2
     *                 o, e.         0
     *                 e, o.         0
     *                 e, e.         2
     *          3. 3 ; o, o, o.      3      
     *                 o, o, e.      1
     *                 o, e, o.      1
     *                 o, e, e.      1
     *                 e, o, o.      1
     *                 e, o, e.      1
     *                 e, e, o.      1
     *                 e, e, e.      3
     *          4. 4 ; o, o, (o, e,) o
     */
    /*
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; ++i) {
            a[i] = in.nextInt();
        }
        
        int cnt = N;
        boolean lastIsOdd, curIsOdd;
        int last = 0;
        lastIsOdd = isOdd(a[last]);
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < N; ++i) {
//            lastIsOdd = isOdd(a[last]);
            curIsOdd = isOdd(a[i]);
            if (lastIsOdd != curIsOdd) {
                cnt -= 2;
                if (!stack.isEmpty()) {
                    last = stack.pop();
                    lastIsOdd = isOdd(a[last]);
                } else {
                    if (i >= N - 2) {
                        break;
                    } else {
                        ++i;
                        last = i;
                    }
                }
            } else {
                stack.push(last);
                last = i;
            }
        }

        System.out.println(cnt);

    }
    */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] a = new int[N];
        int oddCnt = 0;
        int evenCnt = 0;
        for (int i = 0; i < N; ++i) {
            a[i] = in.nextInt();
            if (isOdd(a[i])) {
                ++oddCnt;
            } else {
                ++evenCnt;
            }
        }

        int res;
        if (oddCnt > evenCnt) {
            res = oddCnt - evenCnt;
        } else {
            res = evenCnt - oddCnt;
        }

        System.out.println(res);
        
    }

    public static boolean isOdd(int x) {
        return x % 2 != 0 ? true : false;  
    }
    
}
