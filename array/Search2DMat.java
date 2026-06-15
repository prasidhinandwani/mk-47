class Search2DMat {
    public boolean searchMatrix(int[][] a, int t) {
        int r = 0;
        int c = a[0].length - 1;

        while (r < a.length && c >= 0) {
            if (a[r][c] == t) {
                return true;
            } else if (a[r][c] > t) {
                c--;
            } else {
                r++;
            }
        }

        return false;
    }
}