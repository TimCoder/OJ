package tim.leetcode;

public class __338_CountingBits {

    /*
     *  1——效率很高！
     *  一个二进制数2i 与 i 的1的个数相同;
     *  一个二进制数i 与 i/2的1的个数之差，等于i的二进制末位值
     *  由小的i递推到大的i，且要保证所有的i都被考虑到，所以使用i 和 i / 2
     */

    public static int[] countBits(int num) {

        int[] res = new int[num + 1];
        for (int i = 1; i < num + 1; ++i) {
            res[i] = res[i / 2] + (i & 0x1);
        }

        return res;

    }

    /*
     * Time: O(n * c), Space: O(n).
     * using time: 5ms.
     */
    /*
    public int[] countBits(int num) {

        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i < num + 1; ++i) {
            if ((i & 1) != 0) {
                res[i] = res[i - 1] + 1;
            } else {
                int tmp = i ^ (i - 1);
                if (tmp == 0) {
                    res[i] = res[i - 1];
                } else {
                    int cnt = 0; 
                    while (tmp > 0) {
                        tmp &= tmp - 1;
                        ++cnt;
                    }
                    res[i] = res[i - 1] + 2 - cnt;
                }
            }
        }

        return res;

    }
    */
}
