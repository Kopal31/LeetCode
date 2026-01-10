import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }

            if (!window.add(nums[i])) { //f I try to add nums[i] to the set and it fails, then it was already there → duplicate found.
                return true;
            }
        }
        return false;
    }
}
