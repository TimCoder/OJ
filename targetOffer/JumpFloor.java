package tim.targetOffer;

public class JumpFloor {
     public int JumpFloor(int n) {
         if (n < 2) {
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
