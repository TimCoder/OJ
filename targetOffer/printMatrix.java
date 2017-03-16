package tim.targetOffer;

public class printMatrix {

    private ArrayList<Integer> res = new ArrayList<Integer>();

    public ArrayList<Integer> printMatrix(int [][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return res;
        }

        int m = mat.length; 
        int n = mat[0].length; 
        int l = 0, r = n - 1, t = 0, b = m - 1;
        while (l <= r && t <= b) {
            printHelper(mat, l, r, t, b);
            ++l;
            --r;
            ++t;
            --b;
        }

        return res;
    }

    public void printHelper(int[][] mat, int l, int r, int t, int b) {
        if (l == r && t == b) {
            res.add(mat[t][l]);
            return ;
        }

        if (l == r && t != b) {
            for (int i = t; i <= b; ++i) {
                res.add(mat[i][l]);
            }
            return ;
        }

        if (l != r && t == b) {
            for (int j = l; j < r; ++j) {
                res.add(mat[t][j]);
            }
            return ;
        }
        for (int j = l; j < r; ++j) {
            res.add(mat[t][j]);
        }

        for (int i = t; i < b; ++i) {
            res.add(mat[i][r]);
        }

        for (int j = r; j > l; --j) {
            res.add(mat[b][j]);
        }

        for (int i = b; i > t; --i) {
            res.add(mat[i][l]);
        }
    }

}
