class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;        // Number of rows
        int m = matrix[0].length;     // Number of columns
        int col0 = 1;  // Flag to indicate if the first column needs to be zeroed

        // First pass: mark the first row and first column for zeroing
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Mark the first row and first column
                    matrix[i][0] = 0;  // Mark the current row
                    if (j != 0) {
                        matrix[0][j] = 0;  // Mark the current column
                    } else {
                        col0 = 0;  // Special flag for the first column
                    }
                }
            }
        }

        // Second pass: use the marks to set zeroes
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle the first row separately
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Handle the first column separately
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
