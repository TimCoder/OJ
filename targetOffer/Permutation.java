package tim.targetOffer;

import java.util.TreeSet;
import java.util.ArrayList;

public class Permutation {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null) {
            return res;
        }

        char[] chars = str.toCharArray();
        TreeSet<String> tmp = new TreeSet<>();
        permutation(chars, 0, tmp);
        res.addAll(tmp);

        return res;
    }

    public void permutation(char[] chars, int start, TreeSet<String> result) {
        if (chars == null || chars.length == 0 || start < 0 || start > chars.length - 1) {
            return ;
        }

        if (start == chars.length - 1) {
            result.add(String.valueOf(chars));
        } else {
            for (int i = start; i < chars.length; ++i) {
                char tmp = chars[start]; 
                chars[start] = chars[i];
                chars[i] = tmp; 

                permutation(chars, start + 1, result);

                tmp = chars[start]; 
                chars[start] = chars[i];
                chars[i] = tmp; 
            }
        }
    }
}
