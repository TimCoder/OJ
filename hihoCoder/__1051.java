package tim.hihocoder;

import java.util.Scanner;

public class __1051 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int i = 0; i < num; ++i) {
            int N = in.nextInt();
            int M = in.nextInt();
            /* 此处不能提前结束此次循环，必须读完对应的数组
            if (M >= N) {
                System.out.println(100);
                continue;
            }
             */ 
            
            int[] a = new int[N+2];
            a[0] = 0;
            a[N+1] = 100;
            for (int j = 1; j <= N; ++j) {
                a[j] = in.nextInt();
            }
            if (M >= N) {
                System.out.println(100);
                continue;
            }
            int result = getMaxDays(a, M);
            System.out.println(result);
        }
    }

    public static int getMaxDays(int[] a, int M) {
        int len = a.length;
        int[] dis = new int[len-1];
        for (int i = 1; i < a.length; ++i) {
            dis[i-1] = a[i] - a[i-1];
        }
        return getMaxSerialMSum(dis, M);
    }

    public static int getMaxSerialMSum(int[] dis, int M) {
        int max = 0;
        for (int i = 0; i < dis.length; ++i) {
            int sum = 0;
            int j;
            for (j = i; j < i + M + 1 && j < dis.length; ++j) {
               sum += dis[j]; 
            }
            if (max < sum) {
                if (j == dis.length) {
                    max = sum;
                } else {
                    max = sum - 1;
                }
            }
        }
        return max;
    }

}
