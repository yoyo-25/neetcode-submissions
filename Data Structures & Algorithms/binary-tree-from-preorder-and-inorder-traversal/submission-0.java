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
    public TreeNode solve(int[] preorder, int preStart, int inStart, int inEnd, HashMap<Integer, Integer> inMap){
        if(inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIdx = inMap.get(root.val);
        int leftSize = rootIdx - inStart;

        root.left = solve(preorder, preStart+1, inStart, rootIdx-1, inMap);
        root.right = solve(preorder, preStart+leftSize+1, rootIdx+1, inEnd, inMap);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();

        for(int i=0; i< inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        return solve(preorder, 0, 0, inorder.length-1, inMap);
    }
}
