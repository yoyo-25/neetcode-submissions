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
    public int height(int[] dp, TreeNode root){
        if(root == null) return 0;

        int maxLeft = height(dp, root.left);
        int maxRight = height(dp, root.right);

        dp[0] = Math.max(dp[0], maxRight+maxLeft);

        return 1+Math.max(maxLeft, maxRight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] dp = new int[1];

        height(dp, root);

        return dp[0];
    }
}
