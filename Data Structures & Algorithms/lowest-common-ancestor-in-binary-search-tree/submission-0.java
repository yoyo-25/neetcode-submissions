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
    public TreeNode solve(TreeNode root, TreeNode p, TreeNode q){
        if(root == p || root == q){
            return root;
        }

        if(p.val < root.val && q.val < root.val){
            return solve(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            return solve(root.right, p, q);
        }else return root;
    }
  
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root, p, q);
    }
}
