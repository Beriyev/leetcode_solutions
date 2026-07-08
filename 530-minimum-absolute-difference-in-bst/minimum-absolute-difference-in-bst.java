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
    Integer min = Integer.MAX_VALUE;
    Integer val = null;

    public int getMinimumDifference(TreeNode root) {
        minimum(root);
        return min;
    }

    void minimum(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        minimum(root.left);

        if(val!=null)
        {
            min = Math.min(min,Math.abs(root.val-val));
            val = root.val;
        }
        else
        {
            val = root.val;
        }

        minimum(root.right);
    }
}