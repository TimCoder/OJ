package tim.targetOffer;

public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length == 0) {
            return -1;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); ++i) {
            char tmp = str.charAt(i);
            if (map.containsKey(tmp)) {
                map.put(tmp, map.get(tmp) + 1);
            } else {
                map.put(tmp, 1);
            }
        }

        for (int i = 0; i < str.length(); ++i) {
            char tmp = str.charAt(i);
            if (map.get(tmp) == 1) {
                return i;
            }
        }

        return -1;
    }
}
