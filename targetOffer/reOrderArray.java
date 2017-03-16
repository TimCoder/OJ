package tim.targetOffer;

public class reOrderArray {
    // 1,2,3,4,5
    public void reOrderArray(int[] a) {
        int s = 0;
        int i = 0, n = a.length;
        while (i < n) {
            if ((a[i] & 0x1) != 0) { 
                int tmp = a[i];
                for (int j = i; j > s; --j) {
                    a[j] = a[j - 1];
                }
                a[s++] = tmp;
            }
            ++i;
        }
    }
}
