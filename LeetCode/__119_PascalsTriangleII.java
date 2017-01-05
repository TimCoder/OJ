package tim.leetcode;

import java.util.ArrayList;
import java.util.List;

public class __119_PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> last = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        List<Integer> tmp;
        for (int i = 0; i < rowIndex + 1; ++i) {
            for (int j = 0; j < i; ++j) {
                if (j == 0) {
                    cur.add(1);
                } else {
                    int val = last.get(j - 1) + last.get(j);
                    cur.add(val);
                }
            }
            cur.add(1);
            tmp = last;
            last = cur;
            cur = tmp;
            cur.clear();
        }

        return last;
                
    }

}
