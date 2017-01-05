package tim.leetcode;

import java.util.ArrayList;
import java.util.List;

public class __229_MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int k = 3;
        int[] a = new int[k - 1];
        int[] c = new int[k - 1];
        for (int i = 0; i < k - 1; ++i) {
            a[i] = nums[0];
            c[i] = 0;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == a[0]) { 
                ++c[0];
            } else if (nums[i] == a[1]) { 
                ++c[1];
            /*
                ...
            } else if (nums[i] == a[k - 2]) {
                ++c[k - 2];
            */
            } else if (c[0] == 0) {
                a[0] = nums[i];
                c[0] = 1;
            } else if (c[1] == 0) {
                a[1] = nums[i];
                c[1] = 1;
            /*    
                ...
            } else if (c[k - 2] == 0) {
                a[k - 2] = nums[i];
            */
            } else {
                --c[0];
                --c[1];
                /*
                . ..
                --c[k - 2];
                */
            }
        }

        for (int i = 0; i < k - 1; ++i) {
            c[i] = 0;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == a[0]) {
                ++c[0];
            } else if (nums[i] == a[1]) {
                ++c[1];
            /*
                ...            
            } else if (nums[i] == a[k - 2]) {
                ++c[k - 2];
            */
            }
        }

        for (int i = 0; i < k - 1; ++i) {
            if (c[i] > nums.length / 3) {
                res.add(a[i]);
            }
        }

        return res;
    }
}
