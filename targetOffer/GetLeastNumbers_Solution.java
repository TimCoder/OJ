package tim.targetOffer;

import java.util.*;

public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || input.length < k) {
            return res;
        }

        int[] tmp = new int[k];
        tmp = Arrays.copyOf(input, k);
        buildHeap(tmp, tmp.length - 1);
        for (int i = k; i < input.length; ++i) {
            if (input[i] < tmp[0]) {
                tmp[0] = input[i];
                topDown(tmp, 0, tmp.length - 1);
            }
        }

        for (int i = 0; i < tmp.length; ++i) {
            res.add(tmp[i]);
        }
        return res;
    }

    //        0
    //    1      2
    //  3   4  5   6  
    // 7 8
    public void buildHeap(int[] a, int n) {
        if (a == null || n <= 0) { 
            return ;
        }
        for (int i = (n - 1) / 2; i >= 0; --i) {
            topDown(a, i, n);
        }
    }

    public void topDown(int[] a, int i, int n) {
        if (a == null || i < 0) {
            return ;
        }

        while (i * 2 + 1 <= n) { 
            int maxIndex = i * 2 + 1;
            int lVal = a[maxIndex];
            int max = lVal;
            int rVal = Integer.MIN_VALUE;
            if (maxIndex + 1 <= n) {
                rVal = a[maxIndex + 1];  
                if (lVal < rVal) {
                    max = rVal;
                    maxIndex = maxIndex + 1;
                }
            }

            if (a[i] >= max) {
                return ;
            } else {
                int tmp = a[i];
                a[i] = a[maxIndex];
                a[maxIndex] = tmp;
                i = maxIndex;
            }
        }
    }

}
