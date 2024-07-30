/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int operations = 0;
      
        // BFS traversal of the tree
        while (!queue.isEmpty()) {
            List<Integer> levelValues = new ArrayList<>();
          
            // Process all nodes at the current level
            for (int nodeCount = queue.size(); nodeCount > 0; --nodeCount) {
                TreeNode currentNode = queue.poll();
                levelValues.add(currentNode.val);
              
                // Add the children of the current node to the queue, if they exist
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
          
            // Compute the number of operations needed for this level
            operations += computeOperations(levelValues);
        }
      
        return operations;
    }

    private int computeOperations(List<Integer> levelValues) {
        int size = levelValues.size();
        List<Integer> sortedValues = new ArrayList<>(levelValues);
        sortedValues.sort(Integer::compareTo);
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();
      
        // Map each value to its index in the sorted list
        for (int i = 0; i < size; ++i) {
            valueToIndexMap.put(sortedValues.get(i), i);
        }
      
        // Create an array where each element's value is its index in the sorted list
        int[] indices = new int[size];
        for (int i = 0; i < size; ++i) {
            indices[i] = valueToIndexMap.get(levelValues.get(i));
        }
      
        // Count the number of swaps needed to sort the array
        int swapCount = 0;
        for (int i = 0; i < size; ++i) {
            while (indices[i] != i) {
                swap(indices, i, indices[i]);
                ++swapCount;
            }
        }
      
        return swapCount;
    }

    // Helper method to swap two elements in an array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}