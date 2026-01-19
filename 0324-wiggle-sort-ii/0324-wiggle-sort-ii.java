class Solution {

    public void wiggleSort(int[] nums) {

        int n = nums.length;            // store length of array

        // Step 1: Find the median (middle value)
        // Why median? because it helps split values into:
        // 1) greater than median  -> should go to peaks (odd indices)
        // 2) smaller than median  -> should go to valleys (even indices)
        // 3) equal to median      -> can stay in between
        int median = findKth(nums, (n + 1) / 2);   // kth smallest (lower median)

        // Step 2: Dutch National Flag pointers (3-way partition)
        // low  -> next position for placing > median
        // mid  -> current element to check
        // high -> next position for placing < median
        int low = 0, mid = 0, high = n - 1;

        // Step 3: Partition using virtual indices, not real indices
        // because we want to fill odd indices first (peaks)
        while (mid <= high) {

            // Convert "mid" to a REAL index using magic mapping
            // The mapping visits indices in order: 1,3,5,0,2,4...
            // which means odd indices are handled first (peaks zone)
            int mMid = newIndex(mid, n);

            // CASE 1: If current value is bigger than median
            // It must go to a peak position (odd index)
            if (nums[mMid] > median) {

                // Convert low pointer to its real mapped index
                int mLow = newIndex(low, n);

                // Swap big value into the "front zone" (> median zone)
                swap(nums, mLow, mMid);

                // Expand > median zone AND move forward
                low++;
                mid++;
            }

            // CASE 2: If current value is smaller than median
            // It must go to valley positions (even indices, later in mapping)
            else if (nums[mMid] < median) {

                // Convert high pointer to its real mapped index
                int mHigh = newIndex(high, n);

                // Swap small value into the "end zone" (< median zone)
                swap(nums, mMid, mHigh);

                // shrink the end zone
                high--;

                // IMPORTANT: do NOT mid++
                // because after swapping from end, we got a new number at mMid
                // and it still needs to be checked
            }

            // CASE 3: If current value equals median
            // It belongs to middle zone; just move forward
            else {
                mid++;
            }
        }
    }


    // Virtual Index Mapping:
    // It changes indexing order to:
    // 1,3,5,0,2,4,... (odd indices first)
    // This helps place bigger values in odd indices automatically.
    private int newIndex(int i, int n) {
        // (n | 1) makes n odd:
        // if n = 6 -> 7
        // if n = 7 -> 7
        // This avoids collisions in modulo mapping.
        return (1 + 2 * i) % (n | 1);
    }


    // Basic swap function
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // Quickselect method:
    // returns kth smallest element (k is 1-indexed)
    // Example: k=1 => smallest, k=2 => second smallest
    private int findKth(int[] nums, int k) {

        int left = 0, right = nums.length - 1;

        // convert k to 0-index for internal calculation
        k--;

        while (left <= right) {

            // partition puts pivot in correct sorted position
            int pivotIndex = partition(nums, left, right);

            // If pivotIndex == k, pivot is the kth smallest
            if (pivotIndex == k) {
                return nums[pivotIndex];
            }

            // If kth smallest is on right side
            else if (pivotIndex < k) {
                left = pivotIndex + 1;
            }

            // If kth smallest is on left side
            else {
                right = pivotIndex - 1;
            }
        }

        return -1;  // should not happen
    }


    // Partition function (like QuickSort):
    // After partition:
    // all elements <= pivot are on left
    // all elements > pivot are on right
    // pivot is placed at correct position
    private int partition(int[] nums, int left, int right) {

        int pivot = nums[right];        // choose last element as pivot
        int i = left;                  // boundary for <= pivot region

        // traverse elements except pivot
        for (int j = left; j < right; j++) {

            // if current element belongs to <= pivot region
            if (nums[j] <= pivot) {
                swap(nums, i, j);      // move it to boundary
                i++;                   // expand <= pivot region
            }
        }

        // place pivot in between <= and > regions
        swap(nums, i, right);

        return i;  // pivot's final index
    }
}
