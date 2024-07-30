class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1;
        int n = nums.length;
        //index of the first zero in the array
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                j = i;
                break;
            }
        }
        // If no zero is found, no need to proceed further
        if (j == -1) {
            return;
        }
        // iterating from the first zero to n to swap the elements
        for(int i = j+1; i < n; i++){
            if(nums[i] != 0){
                int temp = 0;
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}