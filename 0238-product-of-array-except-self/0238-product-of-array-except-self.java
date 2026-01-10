class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // -----------------------------
        // 1) PREFIX PRODUCTS
        // -----------------------------
        // ans[i] will store the product of all elements to the LEFT of i.
        //
        // Example nums = [1,2,3,4]
        // ans after prefix step:
        // ans[0] = 1          (no elements on left)
        // ans[1] = 1          (nums[0])
        // ans[2] = 1*2 = 2    (nums[0]*nums[1])
        // ans[3] = 1*2*3 = 6  (nums[0]*nums[1]*nums[2])

        ans[0] = 1; // nothing exists to the left of index 0
        for (int i = 1; i < n; i++) {
            // ans[i-1] already has product of left elements of (i-1)
            // multiply it by nums[i-1] to include nums[i-1] into prefix product
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // -----------------------------
        // 2) SUFFIX PRODUCTS
        // -----------------------------
        // Now we multiply each ans[i] with the product of all elements to the RIGHT of i.
        // Instead of storing suffix array, we maintain a running variable `suffix`.
        //
        // suffix means: product of elements from i+1 to end.
        //
        // We traverse from right to left:
        // - multiply ans[i] (prefix product) by suffix (right product)
        // - then update suffix *= nums[i]

        int suffix = 1; // nothing exists to the right of last index initially
        for (int i = n - 1; i >= 0; i--) {
            // ans[i] currently holds prefix product (left side)
            // multiply by suffix product (right side)
            ans[i] = ans[i] * suffix;

            // update suffix for next iteration (moving left):
            // suffix becomes suffix * nums[i] => includes current element in right product for next index
            suffix *= nums[i];
        }

        return ans;
    }
}
