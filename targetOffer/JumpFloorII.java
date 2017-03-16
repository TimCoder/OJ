package tim.targetOffer;

public class JumpFloorII {
    public int JumpFloorII (int n) {
        //return (int)Math.pow(2, n - 1);
        int res = 1;
        for (int i = 0; i < n - 1; ++i) {
            res *= 2;
        }

        return res;
    }
}
