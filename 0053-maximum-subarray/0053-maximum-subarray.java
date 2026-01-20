class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int subArraySum = 0;

        for(int i = 0; i < nums.length; i++){
            subArraySum += nums[i];
            if(subArraySum > maxSum){
                maxSum = subArraySum;
            }
            if(subArraySum < 0){
                subArraySum = 0;
            }
        }

        return maxSum;
    }
}