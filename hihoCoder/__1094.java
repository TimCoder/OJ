package tim.hihocoder;

import java.util.ArrayList;
import java.util.Scanner;

public class __1094 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        String[] a = new String[N];
        for (int i = 0; i < N; ++i) {
            a[i] = in.next();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; ++i) {
            sb.append(in.next());
        }
        char middle = sb.charAt(4);
        if (N < 3 || M < 3) {
            return;
        }
        ArrayList<String> targetList = new ArrayList<>();
        targetList = getTargetList(sb);

        for (int i = 1; i < N - 1; ++i) {
            for (int j = 1; j < M - 1; ++j) {
                if (a[i].charAt(j) == middle) {
                    check(targetList, a, i, j);
                }
            }
        }

        return;
    }

    public static ArrayList<String> getTargetList(StringBuilder sb) {
        ArrayList<String> list = new ArrayList<String>();
        
        //top left start
        StringBuilder target1 = new StringBuilder();
        target1.append(sb.substring(0, 3))
        .append(sb.charAt(5))
        .append(sb.charAt(8)).append(sb.charAt(7)).append(sb.charAt(6))
        .append(sb.charAt(3));

        //top right start 
        StringBuilder target2 = new StringBuilder();
        target2.append(sb.charAt(2)).append(sb.charAt(5)).append(sb.charAt(8))
        .append(sb.charAt(7))
        .append(sb.charAt(6)).append(sb.charAt(3)).append(sb.charAt(0))
        .append(sb.charAt(1));

        //bottom right start
        StringBuilder target3 = new StringBuilder();
        target3.append(sb.charAt(8)).append(sb.charAt(7)).append(sb.charAt(6))
        .append(sb.charAt(3))
        .append(sb.substring(0, 3))
        .append(sb.charAt(5));

        //bottom left start
        StringBuilder target4 = new StringBuilder();
        target4.append(sb.charAt(6)).append(sb.charAt(3)).append(sb.charAt(0))
        .append(sb.charAt(1))
        .append(sb.charAt(2)).append(sb.charAt(5)).append(sb.charAt(8))
        .append(sb.charAt(7));

        list.add(target1.toString());
        list.add(target2.toString());
        list.add(target3.toString());
        list.add(target4.toString());

        return list;
    }

    public static void check(ArrayList<String> list, String[] a, int i, int j) {
        //顺时针
        StringBuilder cur = new StringBuilder();
        cur.append(a[i-1].substring(j-1, j+2))
        .append(a[i].charAt(j+1))
        .append(a[i+1].charAt(j+1)).append(a[i+1].charAt(j)).append(a[i+1].charAt(j-1))
        .append(a[i].charAt(j-1));
        String curStr = cur.toString();
        
        for (int k = 0; k < list.size(); ++k) {
            String target = list.get(k);
            if(curStr.equals(target)) {
                i = i + 1;
                j = j + 1;
                System.out.println(i + " " + j);
                break;
            }
        }
    }
}

