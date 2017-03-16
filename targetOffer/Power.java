package tim.targetOffer;

public class Power {
    public double Power(double b, int e) {
        if (e == 0) {
            return 1;
        }

        if (e < 0) {
            return 1 / Power(b, -e);
        }

        double half = Power(b, e / 2);
        if ((e & 1) != 0) {
            return half * half * b;
        } else {
            return half * half;
        }
    }
}
