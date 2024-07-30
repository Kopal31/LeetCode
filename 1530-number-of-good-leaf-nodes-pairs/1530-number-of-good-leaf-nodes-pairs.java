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
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> mp = new HashMap<>();
        List<TreeNode> lvs = new ArrayList<>();
        findLvs(root, new ArrayList<>(), lvs, mp);
        int rs = 0;
        for(int i = 0; i < lvs.size(); i++){
            for(int j = i+1; j < lvs.size(); j++){
                List<TreeNode> l_i = mp.get(lvs.get(i));
                List<TreeNode> l_j = mp.get(lvs.get(j));
                for(int k = 0; k < Math.min(l_i.size(),l_j.size()); k++){
                    if(l_i.get(k) != l_j.get(k)){
                        int dis = l_i.size() - k + l_j.size()- k;
                        if(dis <= distance)
                            rs++;
                        break;
                    }
                }
            }
        }
        return rs;
    }
    private void findLvs(TreeNode node, List<TreeNode> trail, List<TreeNode> lvs, Map<TreeNode, List<TreeNode>> mp){
        if(node == null)
            return;
        List<TreeNode> temp = new ArrayList<>(trail);
        temp.add(node);
        if(node.left == null && node.right == null){
            mp.put(node, temp);
            lvs.add(node);
            return;
        }
        findLvs(node.left, temp, lvs, mp);
        findLvs(node.right, temp, lvs, mp);
    }
}