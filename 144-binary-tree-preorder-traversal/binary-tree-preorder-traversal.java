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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrd(root, res);
        return res;
    }

    private void preOrd(TreeNode r, List<Integer> l){
        if(r == null)
            return;
        
        l.add(r.val);
        preOrd(r.left, l);
        preOrd(r.right, l);
    }
}