import java.util.*;

class Solution {

    public int minimumPairRemoval(int[] nums) {

        List<Integer> arr = new ArrayList<>();
        for (int x : nums) arr.add(x);

        int ops = 0;

        while (!isNonDecreasing(arr)) {

            int idx = 0;
            int minSum = arr.get(0) + arr.get(1);

            // find leftmost adjacent pair with minimum sum
            for (int i = 1; i < arr.size() - 1; i++) {
                int sum = arr.get(i) + arr.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }

            // merge arr[idx] and arr[idx+1]
            int merged = arr.get(idx) + arr.get(idx + 1);
            arr.set(idx, merged);
            arr.remove(idx + 1);

            ops++;
        }

        return ops;
    }

    private boolean isNonDecreasing(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(i - 1)) return false;
        }
        return true;
    }
}
