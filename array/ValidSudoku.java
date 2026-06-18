class ValidSudoku {
    public boolean isValidSudoku(char[][] b) {
        boolean[][] r = new boolean[9][9];
        boolean[][] c = new boolean[9][9];
        boolean[][] g = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (b[i][j] == '.') continue;

                int x = b[i][j] - '1';
                int k = (i / 3) * 3 + (j / 3);

                if (r[i][x] || c[j][x] || g[k][x]) {
                    return false;
                }

                r[i][x] = true;
                c[j][x] = true;
                g[k][x] = true;
            }
        }

        return true;
    }
}