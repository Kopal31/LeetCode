/*
class Solution {
    public String reverseWords(String s) {
        
        s = s.trim();

        String[] words = s.split("\\s+");

        StringBuilder ans = new StringBuilder();

        for(int i = words.length - 1; i >=0; i--){
            ans.append(words[i]);
            if(i != 0) ans.append(" ");
        } 

        return ans.toString();
    }
}
*/

class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();

        int i = n-1;

        while(i >= 0){
            //skip the trailing spaces

            while(i >=0 && s.charAt(i) == ' ')i--;

            if(i<0) break;

            int j = i;

            while(i >= 0 && s.charAt(i) != ' ')i--;
            ans.append(s.substring(i+1, j+1));

            ans.append(" ");
        }

        return ans.toString().trim();
    }

    }