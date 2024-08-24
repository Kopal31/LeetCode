import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {
        // Convert nums to a List of Integers to use Collections sorting
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        
        // Sort in reverse order
        Collections.sort(numList, Collections.reverseOrder());
        
        // Create a list to track distinct maximums
        List<Integer> distinctMaxList = new ArrayList<>();
        
        // Add the first element
        distinctMaxList.add(numList.get(0));
        
        // Iterate to find the next distinct maximums
        for (int i = 1; i < numList.size(); i++) {
            // Check if the current number is distinct
            if (!distinctMaxList.contains(numList.get(i))) {
                distinctMaxList.add(numList.get(i));
            }
            // If we have found three distinct maximums, break out of the loop
            if (distinctMaxList.size() == 3) {
                break;
            }
        }
        
        // If we have less than three distinct maximums, return the first one (maximum)
        if (distinctMaxList.size() < 3) {
            return distinctMaxList.get(0);
        } else {
            // Otherwise, return the third maximum
            return distinctMaxList.get(2);
        }
    }
}
