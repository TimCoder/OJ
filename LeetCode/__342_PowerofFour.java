package tim.leetcode;

public class __342_PowerofFour {

    /*
     * Time : O(1).
     * using time : 2 ms.
     */
    public boolean isPowerOfFour(int num) {
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position 
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //return num > 0 && (num&(num-1)) == 0 && (num & 0xaaaaaaaa) == 0;
    }

    /*
     * Time : O(1).
     * using time : 2 ms.
     */
    /*
    public boolean isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("^10*$");
    }
    */

    /*
     * WA. Base must be prime when using this method.
     * Time : O(1).
     * using time : 2 ms.
     */
    /*
    public boolean isPowerOfFour(int num) {
        return n > 0 && 1073741824 % num == 0;
    }
    */

}
