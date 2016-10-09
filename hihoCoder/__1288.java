package tim.hihocoder;

import java.util.Scanner;

public class __1288 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int i = 0; i < num; ++i) {
            int N = in.nextInt();
            int P = in.nextInt();
            int W = in.nextInt();
            int H = in.nextInt();
            int[] a = new int[N];
            for (int j = 0; j < N; ++j) {
                a[j] = in.nextInt();
            }
            int maxS = Math.min(W, H); 
            int wordsPerLine, linesPerPage;
            int lines, totalLines, pages; 
            for (int s = maxS; s > 0; --s) {
                totalLines = 0;
                pages = 0;
                wordsPerLine = W / s;
                linesPerPage = H / s;
                if (wordsPerLine == 0 || linesPerPage == 0) {
                    continue;
                }
                for (int j = 0; j < N; ++j) { 
                    if (a[j] % wordsPerLine == 0) {
                        lines = a[j] / wordsPerLine;
                    } else {
                        lines = a[j] / wordsPerLine + 1;
                    }
                    totalLines += lines;
                } 
                if (totalLines % linesPerPage == 0) {
                    pages = totalLines / linesPerPage;
                } else {
                    pages = totalLines / linesPerPage + 1;
                }
                if (pages <= P) {
                    System.out.println(s);
                    break;
                }
            }
        }
    }
}

