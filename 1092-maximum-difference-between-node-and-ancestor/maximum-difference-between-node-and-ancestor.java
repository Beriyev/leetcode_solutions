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
    int ans = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        maxAncestor(root,min,max);
        return ans;
    }

    void maxAncestor(TreeNode root, int min, int max)
    {
        if(root==null)
        {
            return;
        }
        min = Math.min(min,root.val);
        max = Math.max(max,root.val);
        ans = Math.max(ans,Math.abs(min-max));
        maxAncestor(root.left,min,max);
        maxAncestor(root.right,min,max);
    }
}