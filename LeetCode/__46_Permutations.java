package tim.leetcode;

public class __46_Permutations {
    /*
     * Recursion I
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //Arrays.sort(nums); // not necessary
        recursiveBySwap(res, nums, 0);
        return res;
    }

    public void recursiveBySwap(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                tmp.add(nums[i]);
            }
            res.add(tmp);
        } else {
            for (int i = start; i < nums.length; ++i) {
                swsp(nums, i, start);
                recursiveBySwap(res, nums, start + 1);
                swap(nums, i, start);
            }
        }
    }

    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /*
     * Recursion II
     */
    /*
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //Arrays.sort(nums); // not necessary
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            //printList(tmp);
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (tmp.contains(nums[i])) {
                    continue;
                }
                tmp.add(nums[i]);
                backtrack(res, tmp, nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    */

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

}
