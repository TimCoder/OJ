package tim.targetOffer;

public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str == null || str.trim().length() == 0) {
            return str;
        }

        StringBuilder res = new StringBuilder();
        String strR = new StringBuilder(str).reverse().toString();
        String[] tmp = strR.split(" ");
        for (int i = 0; i < tmp.length; ++i) {
            if (i == 0) {
                res.append(new StringBuilder(tmp[i]).reverse());
                continue;
            }
            res.append(" ").append(new StringBuilder(tmp[i]).reverse());
        }

        return res.toString();
    }
}
