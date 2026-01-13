import java.util.*;

class Solution {
    public double separateSquares(int[][] squares) {
        // Total area = sum(l*l). Need Y such that area below Y == total/2
        double halfArea = 0;
        List<int[]> events = new ArrayList<>(); // {y, type(1=start,0=end), l}

        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            halfArea += 1.0 * l * l;

            events.add(new int[]{y, 1, l});      // square starts at y -> add width +l
            events.add(new int[]{y + l, 0, l});  // square ends at y+l -> remove width -l
        }

        halfArea /= 2.0;

        // Sort by y (sweep line)
        events.sort(Comparator.comparingInt(a -> a[0]));

        double area = 0;     // area accumulated below current sweep position
        long width = 0;      // total active "width" (sum of l's of active squares)
        int prevY = events.get(0)[0];

        for (int[] e : events) {
            int y = e[0];
            int l = e[2];

            // Area gained in segment [prevY, y)
            long dy = (long) y - prevY;
            if (dy > 0 && width > 0) {
                double areaGain = width * (double) dy;

                // If halfArea lies inside this segment, solve exact Y by linear interpolation
                if (area + areaGain >= halfArea) {
                    return prevY + (halfArea - area) / width;
                }

                area += areaGain;
            }

            // Update width at this y
            if (e[1] == 1) width += l; // start
            else width -= l;           // end

            prevY = y;
        }

        // Should never happen with valid input
        return prevY;
    }
}
