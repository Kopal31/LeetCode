class Solution {
    public void wiggleSort(int[] nums) {
        int[] a = nums.clone();
        Arrays.sort(a);
        int n = nums.length;
        int l = (n - 1) / 2, r = n - 1;
        for (int i = 0; i < n; i++)
            nums[i] = (i % 2 == 0) ? a[l--] : a[r--];
    }
}