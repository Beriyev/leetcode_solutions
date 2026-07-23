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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,inorder.length-1,0,preorder.length-1);
    }

    TreeNode build(int[] preorder, int[] inorder, int inorderStart, int inorderEnd, int preorderStart, int preorderEnd)
    {
        if(preorderStart>preorderEnd)
        {
            return null;
        }
        if(inorderStart>inorderEnd)
        {
            return null;
        }

        int rootVal = preorder[preorderStart];

        int i = inorderStart;

        while(inorder[i]!=rootVal)
        {
            i++;
        }

        int left = i-inorderStart;
        
        TreeNode root = new TreeNode(rootVal);

        root.left = build(preorder,inorder,inorderStart,i-1,preorderStart+1,preorderStart+left);
        root.right = build(preorder,inorder,i+1,inorderEnd,preorderStart+left+1,preorderEnd);

        return root;
    }
}