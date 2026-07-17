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
    StringBuilder str = new StringBuilder();

    public String tree2str(TreeNode root) {
        string(root);
        return str.toString();
    }

    void string(TreeNode root)
    {
        if(root==null)
        {

            return;
        }

        str.append(String.valueOf(root.val));

        if(root.left==null&&root.right==null)
        {
            return;
        }
        
        if(root.left==null&&root.right!=null)
        {
            str.append("()");
            str.append("(");
            string(root.right);
            str.append(")");
        }
        else
        {
            str.append("(");
            string(root.left);
            str.append(")");
            if(root.right!=null)
            {
                str.append("(");
                string(root.right);
                str.append(")");
            }
        }
    }
}