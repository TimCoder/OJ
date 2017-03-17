package tim.targetOffer;

public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return verifyHelper(sequence, 0, sequence.length - 1);
    }

    public boolean verifyHelper(int[] a, int s, int e) {
        if (s >= e) {
            return true;
        }

        int root = a[e]; 
        int i = s;
        while (i < e) {
            if (a[i] > root) {
                break;
            }
            ++i;
        }
        int j = i;
        while (j < e) {
            if (a[j] < root) {
                return false;
            }
            ++j;
        }

        return verifyHelper(a, s, i - 1) && verifyHelper(a, i, e - 1);
    }
}
