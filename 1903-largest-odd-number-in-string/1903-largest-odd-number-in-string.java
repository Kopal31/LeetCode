class Solution {
    public String largestOddNumber(String num) {
        
        for(int i = num.length()-1; i >= 0; i--){
            char ch = num.charAt(i);

            int digit = ch - '0';

            if(digit % 2 == 1){
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}