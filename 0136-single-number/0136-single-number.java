import java.util.HashMap;

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each number
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Find the number that appears only once
        for (int num : nums) {
            if (frequencyMap.get(num) == 1) {
                return num;
            }
        }
        
        return -1; // This line should never be reached if the input guarantees a single number
    }
}
