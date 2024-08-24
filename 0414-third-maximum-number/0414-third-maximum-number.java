import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        //creat a list to store the element
        List<Integer>list=new ArrayList<>();
        for(int num : set){
            list.add(num);
        }
        Collections.sort(list,Collections.reverseOrder());
        if(list.size()<3){
            return list.get(0);
        }
           return  list.get(2);  
    }
}
