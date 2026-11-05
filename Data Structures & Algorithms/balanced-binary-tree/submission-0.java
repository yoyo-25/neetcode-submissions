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
    public int func(TreeNode root){
        if(root == null) return 0;

        int leftMax = func(root.left);
        if(leftMax == -1) return -1;

        int rightMax = func(root.right);
        if(rightMax == -1) return -1;

        if(Math.abs(leftMax - rightMax) > 1) return -1;

        return 1+Math.max(leftMax, rightMax);
    }

    public boolean isBalanced(TreeNode root) {
        return func(root) != -1;
    }
}
