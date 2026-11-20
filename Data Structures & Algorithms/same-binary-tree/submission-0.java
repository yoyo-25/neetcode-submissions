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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p==null && q!=null) || (p!=null && q==null)) return false;
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(p);
        q2.offer(q);

        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode pCrnt = q1.poll();
            TreeNode qCrnt = q2.poll();

            if(pCrnt == null && qCrnt == null) continue;
            if((pCrnt == null && qCrnt != null) || (pCrnt != null && qCrnt == null)) return false;
            if(pCrnt.val != qCrnt.val) return false;

            q1.offer(pCrnt.left);
            q1.offer(pCrnt.right);

            q2.offer(qCrnt.left);
            q2.offer(qCrnt.right);
        }

        return true;
    }
}
