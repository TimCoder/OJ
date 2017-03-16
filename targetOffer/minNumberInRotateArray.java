package tim.targetOffer;

public class minNumberInRotateArray {
    //Time: O(log N)
    //test : 3,4,5,6,2,3
    //       4,5,1,2,3,3
    //       1,1,1,2,3
    //       2,1,2,2,2
    //       9,1,2,9,9,9,9
    //       2,2,2,2,2
    public int minNumberInRotateArray(int [] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
            
        int l = 0, r = a.length - 1;
        while (l <= r) {
            if (a[l] < a[r]) {
                return a[l];
            }
            int m = l + (r - l) >> 2;
            if (a[l] < a[m]) {
                l = m;
            } else if (a[l] > a[m]) {
                r = m;
            } else {
                if (a[m] == a[r]) {
                    r = m - 1;
                } else {
                    l = m + 1; 
                }
            }
        }

        return a[l];
    }
}
