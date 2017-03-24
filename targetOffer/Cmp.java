import java.util.*;

public class Cmp {
    public int cmp(int g1, int g2, int[][] records, int n) {
        if (records == null || records.length == 0 || n <= 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            max = Math.max(Math.max(records[i][0], records[i][1]),max);
        }

        //construct directed graph
        int[][] map = new int[max + 1][max + 1];
        for (int i = 1; i <= max; ++i) {
            for (int j = 1; j <= max; ++j) {
                map[i][j] = (i == j) ? 1 : 0;
            }
        }

        for (int i = 0; i < n; ++i) {
            map[records[i][0]][records[i][1]] = 1;
        }

        for (int i = 1; i <= max; ++i) {
            for (int j = 1; j <= max; ++j) { 
                for (int k = 1; k <= max; ++k) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        if (map[g1][g2] == 1) {
            return 1;
        } else if (map[g2][g1] == 1) {
            return -1;
        } else {
            return 0;
        }
    }
}
