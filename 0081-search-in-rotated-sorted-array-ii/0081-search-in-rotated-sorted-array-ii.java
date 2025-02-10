class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) return true; // Target found
            
            // If we have duplicates, skip them
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // Left half is sorted
            else if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) 
                    right = mid - 1; // Narrow search to the left half
                else 
                    left = mid + 1; // Narrow search to the right half
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) 
                    left = mid + 1; // Narrow search to the right half
                else 
                    right = mid - 1; // Narrow search to the left half
            }
        }
        
        return false; // Target not found
    }
}
