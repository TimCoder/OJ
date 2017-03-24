import java.util.*;

public class Finder {
    public int findKth(int[] a, int n, int K) {
        //Kth means n - K + 1 in ascending sort.
        return findKth(a, 0, n - 1,  n - K + 1);
    }

    public int findKth(int[] a, int l, int r, int K) {
        int p = partation(a, l, r);
        if (p - l + 1 == K) {
            return a[p];
        } else if (p - l + 1 < K) {
            return findKth(a, p + 1, r, K - p + l - 1);
        } else {
            return findKth(a, l, p - 1, K);
        }
    }

    // 3,2,1
    // 1,2,3
    // 2,1,3
    public int partation(int[] a, int l, int r) {
        int x = a[l];
        while (l < r) {
            while (l < r && a[r] > x) {
                --r;
            }
            if (l < r) {
                a[l++] = a[r];
            }
            while (l < r && a[l] < x) {
                ++l;
            }
            if (l < r) {
                a[r--] = a[l];
            }
        }
        a[l] = x;
        return l;
    }
}
