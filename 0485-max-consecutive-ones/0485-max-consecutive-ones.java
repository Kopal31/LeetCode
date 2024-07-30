class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0; // To store the maximum count of consecutive ones
        int count = 0; // To store the current count of consecutive ones

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
                if(count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0; // Reset the count when a zero is found
            }
        }

        return maxCount;
    }
}
