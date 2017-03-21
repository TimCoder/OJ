package tim.targetOffer;

import java.util.*;

public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || input.length < k) {
            return res;
        }

        int[] tmp = new int[k];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < input.length; ++i) {
            if (i < k) {
                set.add(input[i]);
                continue;
            }
            if (input[i] < set.last()) {
                set.pollLast();
                set.add(input[i]);
            }
        }

        for (Integer x : set) {
            res.add(x);
        }
        return res;
    }

}
