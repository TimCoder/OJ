package tim.targetOffer;

public class replaceSpace {
    public String replaceSpace1(StringBuffer sb) {
        if (sb == null) {
            return null;
        }

        char[] a = sb.toString().toCharArray();
        int c = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == ' ') {
                ++c;
            }
        }
        int newL = a.length + 2 * c;
        char[] res = new char[newL];
        int i = 0, j = 0; 
        while (i < a.length) {
            if (a[i] != ' ') {
                res[j++] = a[i];
            } else {
                res[j++] = '%';
                res[j++] = '2';
                res[j++] = '0';
            }
            ++i;
        }

        //return new String(res);
        return String.valueOf(res);
    }

    public String replaceSpace2(StringBuffer sb) { 
        if (sb == null) {
            return null;
        }

        int len = sb.length();
        int i =0;
        while (i < len) {
            if (sb.charAt(i) == ' ') {
                sb.deleteCharAt(i);
                sb.insert(i++, '%');
                sb.insert(i++, '2');
                sb.insert(i++, '0');
                len += 2;
            } else {
                ++i;
            }
        }

        return sb.toString();
    }

}
