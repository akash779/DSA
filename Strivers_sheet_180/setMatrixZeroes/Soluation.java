package Strivers_sheet_180.setMatrixZeroes;
class Solution {
    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        boolean is_first_row_zero = false;
        boolean is_first_col_zero = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (i == 0 && matrix[i][j] == 0) {
                    is_first_row_zero = true;
                }
                if (j == 0 && matrix[i][j] == 0) {
                    is_first_col_zero = true;
                }

                if (matrix[i][j] == 0 && i > 0 && j > 0) {

                    matrix[0][j] = 0;
                    matrix[i][0] = 0;

                }

            }
        }

        for (int j = 1; j < col; j++) {

            if (matrix[0][j] == 0) {

                for (int i = 1; i < row; i++) {

                    matrix[i][j] = 0;

                }

            }

        }

        for (int i = 1; i < row; i++) {

            if (matrix[i][0] == 0) {

                for (int j = 1; j < col; j++) {

                    matrix[i][j] = 0;

                }

            }

        }

        if (is_first_row_zero == true) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (is_first_col_zero == true) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}