class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = -1;  // Start with -1 for the last element
        
        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];  // Save the current element
            arr[i] = max;  // Replace the current element with the largest element to its right
            max = Math.max(max, current);  // Update the max to be the maximum of current and previous max
        }
        
        return arr;
    }
}
