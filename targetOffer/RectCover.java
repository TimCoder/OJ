package tim.targetOffer;

public class RectCover {
    public int RectCover (int n) {
        if (n <= 1) {
            return n;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; ++i) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
}
