package tim.hihocoder;

import java.util.Scanner;

public class __1082 {

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            String result = line.replaceAll("[mM][aA][rR][sS][hH][tT][oO][mM][pP]", "fjxmlhx");
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            int len = line.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; ++i) {
                if (len - i < 9) {
                    sb.append(line.substring(i, len));
                    break;
                }
                if ("marshtomp".equalsIgnoreCase(line.substring(i, i + 9))){
                    sb.append("fjxmlhx");
                    i = i + 9 - 1;
                } else {
                    sb.append(line.charAt(i));
                }
            }
            String result = sb.toString();
            System.out.println(result);
        }
    }

}
