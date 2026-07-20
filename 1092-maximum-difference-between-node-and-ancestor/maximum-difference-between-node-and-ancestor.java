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
    int max = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        maxDiff(root);
        return max;
    }

    void maxDiff(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        max = Math.max(max,Math.max(Math.abs(root.val-findMin(root)),Math.abs(root.val-findMax(root))));
        maxDiff(root.left);
        maxDiff(root.right);
    }

    int findMin(TreeNode root)
    {
        if(root==null)
        {
            return Integer.MAX_VALUE;
        }
        int left = findMin(root.left);
        int right = findMin(root.right);

        return Math.min(root.val,Math.min(left,right));
    }
    
    int findMax(TreeNode root)
    {
        if(root==null)
        {
            return Integer.MIN_VALUE;
        }
        int left = findMax(root.left);
        int right = findMax(root.right);

        return Math.max(root.val,Math.max(left,right));
    }
}