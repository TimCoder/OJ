package tim.leetcode;

import java.util.ArrayList;
import java.util.List;

public class __78_Subsets {

    /*
     * Recursive —— Backtracking
     * first  : [[], [1], [1, 2], [1, 2, 3]]
     * second : [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //Arrays.sort(nums); // no need to sort.
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) { 
        res.add(new ArrayList<Integer>(tmp));
        for (int i = start; i < nums.length; ++i) {
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public void printList(List<Integer> list) {
        if (list.size() == 0) {
            System.out.println("[]");
            return ;
        }
        System.out.print("[" +list.get(0));
        for (int i = 1; i < list.size(); ++i) {
            System.out.print("," + list.get(i));
        }
        System.out.println("]");
    }

    /*
     * Iterative
     *  This problem can also be solved iteratively. Take [1, 2, 3] in the problem statement as an example. The process of generating all the subsets is like:
     *   Initially: [[]]
     *   Adding the first number to all the existed subsets: [[], [1]];
     *   Adding the second number to all the existed subsets: [[], [1], [2], [1, 2]];
     *   Adding the third number to all the existed subsets: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]].
     */
    /*
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; ++i) {
            int n = res.size();
            for (int j = 0; j < n; ++j) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }
    */

    /* 
     * Bit-Manipulation
     * This is the most clever solution that I have seen. The idea is that to give all the possible subsets, we just need to exhaust all the possible combinations of the numbers. And each number has only two possibilities: either in or not in a subset. And this can be represented using a bit.

     * There is also another a way to visualize this idea. That is, if we use the above example, 1 appears once in every two consecutive subsets, 2 appears twice in every four consecutive subsets, and 3 appears four times in every eight subsets, shown in the following (initially the 8 subsets are all empty):

     * [], [], [], [], [], [], [], []

     * [], [1], [], [1], [], [1], [], [1]

     * [], [1], [2], [1, 2], [], [1], [2], [1, 2]

     * [], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]
     */
    /*
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = (int) Math.pow(2, nums.length);
        for (int i = 0; i < n; ++i) {
            res.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < n; ++j) {
                if (((j >> i) & 1) == 1) {
                    res.get(j).add(nums[i]);
                }
            }
        }
        return res;
    }
    */

}
