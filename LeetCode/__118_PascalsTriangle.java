package tim.leetcode;

public class __118_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
                
        List<List<Integer>> res = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; ++i) {
            List<Integer> list = new ArrayList<>(i + 1);
            for (int j = 0; j < i; ++j) {
                if (j == 0) {
                    list.add(1);
                } else {
                    int val = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                    list.add(val);
                }
            }
            list.add(1);
            res.add(list);
        }

        return res;

    }

}
