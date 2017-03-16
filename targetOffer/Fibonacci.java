package tim.targetOffer;

public class Fibonacci {
    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        int a = 0;
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
