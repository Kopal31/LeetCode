class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;

        for (int i = 1; i < points.length; i++) {
            int x1 = points[i - 1][0], y1 = points[i - 1][1];
            int x2 = points[i][0], y2 = points[i][1];

            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);

            // With diagonal moves allowed, the minimum steps are:
            // take diagonal moves for min(dx, dy) steps
            // then straight moves for the remaining difference
            // => total = max(dx, dy)
            time += Math.max(dx, dy);
        }

        return time;
    }
}
