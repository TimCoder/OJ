package tim.targetOffer;

public class MoreThanHalfNum_Solution {
    /*
     * time : O(N)
     * space: O(1) 
     */
    public int MoreThanHalfNum_Solution(int [] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == res) {
                ++cnt;
                res = a[i];
            } else {
                if (cnt == 0) {
                    res = a[i];
                    cnt = 1;
                } else {
                    --cnt;
                }
            }
        }

        cnt = 0;
        for (int x : a) {
            if (x == res) {
                ++cnt;
            }
        }

        return cnt * 2 > a.length ? res : 0;
    }

    /* time : O(N)
     * space: O(N)
    public int MoreThanHalfNum_Solution(int [] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;
        for (int x : a) {
            if (map.containsKey(x)) {
                int c = map.get(x);
                map.put(x, c + 1);
                if (c + 1 > max) {
                    max = c + 1;
                    res = x;
                }
            } else {
                map.put(x, 1);
                if (1 > max) {
                    max = 1;
                    res = x;
                }
            }
        }

        return max * 2 > a.length ? res : 0;
 
    }
    */
}
