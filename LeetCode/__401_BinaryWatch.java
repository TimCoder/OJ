package tim.leetcode;

import java.util.ArrayList;
import java.util.List;

public class __401_BinaryWatch {
    /*
     * Just go through the possible times and collect those with the correct number of one-bits.
     * using time : 35 ms.
     */ 
    /*
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h * 64 + m) == num) {
                //if (Integer.bitCount(h + m * 64) == num) { //both 'h * 64 + m and h + m * 64' is OK.
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return res;
    }
    */

    /*
     * Pre processing each case of hour and minute.
     * using time : 1 ms.
     */
    /*
    String[][] hour = {{"0"}, 
                       {"1", "2", "4", "8"},
                       {"3", "5", "6", "9", "10"},
                       {"7", "11"}};
    String[][] minute = {{"00"}, //1
                         {"01", "02", "04", "08", "16", "32"}, //6
                         {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"}, //15
                         {"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"}, //20
                         {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"}, //14
                         {"31", "47", "55", "59"}}; //4
    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList();
        for (int i = 0; i <= 3 && i <= num; i++) {
            if (num - i <= 5) {
                for (String str1 : hour[i]) {
                    for (String str2 : minute[num - i]) {
                        ret.add(str1 + ":" + str2);
                    }
                }
            }
        }
        return ret;    
    }
    */
    
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] nums1 = new int[] {1, 2, 4, 8};
        int[] nums2 = new int[] {1, 2, 4, 8, 16, 32};
        for (int i = 0; i <= num; ++i) {
            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();
            generateDigit(l1, i, 0, 0, nums1);
            generateDigit(l2, num - i, 0, 0, nums2);
            for (int j = 0; j < l1.size(); ++j) {
                if (l1.get(j) >= 12) {
                    continue;
                }
                for (int k = 0; k < l2.size(); ++k) {
                    if (l2.get(k) >= 60) {
                        continue;
                    }
                    //using 3ms.
                    res.add(l1.get(j) + ":" + (l2.get(k) < 10 ? "0" + l2.get(k) : l2.get(k))); 
                    //using 33ms. because of using String.format().
                    // res.add(String.format("%d:%02d", l1.get(j), l2.get(k)));
                }
            }
        }
        return res;
    }

    public void generateDigit(List<Integer> list, int count, int start, int sum, int[] nums) {
        if (count == 0) {
            list.add(sum);
        } else {
            for (int i = start; i < nums.length; ++i) {
                generateDigit(list, count - 1, i + 1, sum + nums[i], nums);
            }
        }
    }
}
