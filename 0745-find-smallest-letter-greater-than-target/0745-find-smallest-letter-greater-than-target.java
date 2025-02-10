class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Find middle index

            if (letters[mid] > target) {
                right = mid - 1; // Move left to find a smaller valid letter
            } else {
                left = mid + 1; // Move right, looking for something greater
            }
        }

        // If `left` goes out of bounds, wrap around to the first letter
        return letters[left % letters.length];
    }
}
