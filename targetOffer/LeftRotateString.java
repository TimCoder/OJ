package tim.targetOffer;

public class LeftRotateString {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || str.length() <= n || n < 0) {
            return str;
        }

        char[] a = str.toCharArray();
        reverse(a, 0, n - 1);
        reverse(a, n, a.length - 1);
        reverse(a, 0, a.length - 1);

        return new String(a);
    }

    public void reverse(char[] a, int start, int end) {
        if (a == null) {
            return ;
        }

        while (start < end) { 
            char tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            ++start;
            --end;
        }
    }
}
