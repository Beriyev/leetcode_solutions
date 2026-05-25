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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = root;
        TreeNode temp = root;
        if(root==null)
        {
            return null;
        }
        while(temp!=null&&temp.val!=key)
        {
            parent = temp;
            if(temp.val<key)
            {
                temp = temp.right;
            }
            else if(temp.val>key)
            {
                temp = temp.left;
            }
        }
        if(temp==null)
        {
            return root;
        }
        if(temp==root)
        {
            if(root.left==null)
            {
                return root.right;
            }
            if(root.right==null)
            {
                return root.left;
            }
        }
        if(temp!=null&&temp.left==null&&temp.right==null)
        {
            if(parent.left==temp)
            {
                parent.left = null;
            }
            else
            {
                parent.right = null;
            }
        }
        if(temp!=null&&temp.left==null&&temp.right!=null)
        {
            if(parent.right==temp)
            {
                parent.right = temp.right;
            }
            else
            {
                parent.left = temp.right;
            }
        }
        if(temp!=null&&temp.left!=null&&temp.right==null)
        {
            if(parent.right==temp)
            {
                parent.right = temp.left;
            }
            else
            {
                parent.left = temp.left;
            }
        }
        if(temp!=null&&temp.left!=null&&temp.right!=null)
        {
            TreeNode temp2 = temp.right;
            TreeNode parent2 = temp;
            while(temp2.left!=null)
            {
                parent2 = temp2;
                temp2 = temp2.left;
            }
            temp.val = temp2.val;
            if(parent2.left==temp2)
            {
                parent2.left = temp2.right;
            }
            else
            {
                parent2.right = temp2.right;
            }
        }
        return root;
    }
}