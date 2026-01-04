class Solution {
    public int numOfWays(int n) {
        int MOD = 1_000_000_007;

        // dpA = number of ways where current row is ABA
        // dpB = number of ways where current row is ABC
        long dpA = 6; // row 1
        long dpB = 6; // row 1

        for (int i = 2; i <= n; i++) {
            long newA = (3 * dpA + 2 * dpB) % MOD;
            long newB = (2 * dpA + 2 * dpB) % MOD;

            dpA = newA;
            dpB = newB;
        }

        return (int) ((dpA + dpB) % MOD);
    }
}
