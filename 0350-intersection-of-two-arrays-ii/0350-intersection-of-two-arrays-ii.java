import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Store the frequency of each element in nums1
        for (int num : nums1) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        // Find the intersection with nums2
        for (int num : nums2) {
            if (mp.containsKey(num) && mp.get(num) > 0) {
                result.add(num);
                mp.put(num, mp.get(num) - 1);
            }
        }

        // Convert the result list to an array
        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }

        return intersection;
    }
}
