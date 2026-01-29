class Solution {

    public long minimumCost(
            String source,
            String target,
            char[] original,
            char[] changed,
            int[] cost
    ) {

        // We have only 26 lowercase English letters
        int n = 26;

        // A large value to represent "infinite" cost
        int INF = (int) 1e9;

        // dist[i][j] will store the minimum cost to convert
        // character (char)(i + 'a') to (char)(j + 'a')
        int[][] dist = new int[n][n];

        // Step 1: Initialise the distance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Cost is 0 to convert a character to itself
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    // Initially, assume conversion is impossible
                    dist[i][j] = INF;
                }
            }
        }

        // Step 2: Fill direct conversion costs
        // Multiple conversions between same characters may exist,
        // so we take the minimum cost
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }

        // Step 3: Floyd–Warshall algorithm
        // This finds the minimum cost between all pairs of characters
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // If going through character k gives a cheaper path,
                    // update the distance
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Step 4: Calculate total minimum cost to convert source to target
        long totalCost = 0;

        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';

            // If conversion is impossible, return -1
            if (dist[s][t] == INF) {
                return -1;
            }

            // Add the minimum cost for this character conversion
            totalCost += dist[s][t];
        }

        return totalCost;
    }
}
