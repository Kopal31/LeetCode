import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {
        int count =1;
       Arrays.sort(nums);
       for(int i=nums.length-2;i>=0;i--){
        if(nums[i] != nums[i+1]){
            count++;
        }
        if(count == 3){
            return nums[i];
        }
       }
       return nums[nums.length-1];
    }
}
