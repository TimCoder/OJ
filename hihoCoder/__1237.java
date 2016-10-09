package tim.hihocoder;

import java.util.Scanner;

public class __1237 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        double y = in.nextDouble();
        double r = in.nextDouble();
        int minI = (int)Math.ceil(x - r);
        int maxI = (int)Math.floor(x + r);
        double maxDis = 0, dis;
        int resX = -1993, resY = -1993;
        //cur point is (i,j), compare all the x's 2 max distance, find out the farthest point.
        for (int i = maxI; i >= minI; --i) {
            int j = (int)Math.floor(y + Math.sqrt(r * r - (i - x) * (i - x)));
            dis = (i - x) * (i - x) + (j - y) * (j - y);
            if (maxDis < dis) {
                resX = i;
                resY = j;
                maxDis = dis;
            }

            j = (int)Math.ceil(y - Math.sqrt(r * r - (i - x) * (i - x)));
            dis = (i - x) * (i - x) + (j - y) * (j - y);
            if (maxDis < dis) {
                resX = i;
                resY = j;
                maxDis = dis;
            }
        }
        System.out.println(resX + " " + resY);
    }
    
}

