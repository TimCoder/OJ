package tim.targetOffer;

import java.util.Stack;

public class IsPopOrder {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || pushA.length == 0 || popA == null || popA.length == 0 || pushA.length != popA.length) {
            return false;
        }

        Stack<Integer> s = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < popA.length; ++i) {
            if (s.isEmpty() && j < pushA.length) {
                s.push(pushA[j++]);
            }
            while (popA[i] != s.peek()) {
                if (j == pushA.length) {
                    return false;
                }
                s.push(pushA[j++]);
            }
            s.pop();
        }

        return true;

    }
}
