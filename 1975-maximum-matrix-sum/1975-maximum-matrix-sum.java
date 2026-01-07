class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negCount = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0) negCount++;
                int absVal = Math.abs(val);
                sum += absVal;
                minAbs = Math.min(minAbs, absVal);
            }
        }

        // If odd number of negatives, one must stay negative
        if (negCount % 2 == 1) {
            sum -= 2L * minAbs;
        }

        return sum;
    }
}
