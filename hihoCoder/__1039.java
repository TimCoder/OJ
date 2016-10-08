package tim.hihocoder;

import java.util.Scanner;

public class __1039 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; ++i) {
            String rawIn = in.next();
            int rawLen = rawIn.length();
            int minLen = delete(rawIn);
            int score = rawLen + 1 - minLen;
            System.out.println(score);
        }
    }

    public static int delete(String input) {
        int aLen = deleteChar(input, 'A');
        if (aLen == 0) {
            return 0;
        }

        int bLen = deleteChar(input, 'B');
        if (bLen == 0) {
            return 0;
        }

        int cLen = deleteChar(input, 'C');
        if (cLen == 0) {
            return 0;
        }

        if (aLen < bLen) {
            if (aLen < cLen) {
                return aLen;
            } else {
                return cLen;
            }
        } else {
            if (bLen < cLen) {
                return bLen;
            } else {
                return cLen;
            }
        }
    }

    public static int deleteChar(String input, char c) {
        StringBuilder sb = new StringBuilder(input);
        int N = input.length();
        int minLen = N;
        for (int i = 1; i < N + 1; ++i) {
            if (minLen == 0) {
                break;
            }
            sb.insert(i, c);
            int len = deleteReChar(new StringBuilder(sb));
            if (minLen > len) {
                minLen = len;
            }
            sb.deleteCharAt(i);
        }

        return minLen;
    }

    public static int deleteReChar(StringBuilder input) {
        if (!hasRepeat(input)) {
            return input.length();
        }
        
        boolean isRepeat = false;
        int startRe = 0;
        for (int i = 1; i < input.length(); ++i) {
            if (input.charAt(i-1) == input.charAt(i)) {
                if (!isRepeat) {
                    startRe = i - 1;
                    isRepeat = true;
                }
            } else {
                if (isRepeat) {
                    isRepeat = false;
                    input.delete(startRe, i);
                    i = startRe;
                }
            }
        }
        if (isRepeat) {
            input.delete(startRe, input.length());
        }
        
        return deleteReChar(input);
    }

    public static boolean hasRepeat(StringBuilder input) {
        int N = input.length();
        for (int i = 1; i < N; ++i) {
            if (input.charAt(i - 1) == input.charAt(i)) {
                return true;
            }
        }
        return false;
    }

}
