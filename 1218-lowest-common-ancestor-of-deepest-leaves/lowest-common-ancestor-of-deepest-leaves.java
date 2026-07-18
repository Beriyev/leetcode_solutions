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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null)
        {
            return null;
        }
        if(depth(root.left)>depth(root.right))
        {
            return lcaDeepestLeaves(root.left);
        }
        if(depth(root.left)<depth(root.right))
        {
            return lcaDeepestLeaves(root.right);
        }
        return root;
    }

    int depth(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        return 1+Math.max(depth(root.left),depth(root.right));
    }
}