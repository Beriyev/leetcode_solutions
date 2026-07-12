/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowest(root,p,q);
    }

    TreeNode lowest(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null)
        {
            return null;
        }
        if(root==p)
        {
            return p;
        }
        if(root==q)
        {
            return q;
        }

        TreeNode left = lowest(root.left,p,q);
        TreeNode right = lowest(root.right,p,q);

        if(left!=null&&right==null)
        {
            return left;
        }

        if(right!=null&&left==null)
        {
            return right;
        }

        if(left!=null && right!=null)
        {
            return root;
        }
        return null;
    }
}