package tim.leetcode;

public class __74_Searcha2DMatrix {
    /*
     * Time : O(log(M * N)).
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1; 
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (matrix[mid / n][mid % n] == target) { 
                return true;
            } else if (matrix[mid / n][mid % n] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }

    /*
     * Time : O(M + N).
     */
    /*
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                ++i;
            } else {
                --j;
            }
        }
        
        return false;
    }
    */

}
