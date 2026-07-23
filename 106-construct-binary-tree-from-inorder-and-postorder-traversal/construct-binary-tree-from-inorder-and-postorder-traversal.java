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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inorderStart = 0;
        int inorderEnd = inorder.length-1;
        int postorderStart = 0;
        int postorderEnd = inorder.length-1;
        return build(inorder,postorder,inorderStart,inorderEnd,postorderStart,postorderEnd);
    }

    TreeNode build(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postorderStart, int postorderEnd)
    {
        if((inorderEnd<inorderStart))
        {
            return null;
        }
        if((postorderEnd<postorderStart))
        {
            return null;
        }
        
        int rootVal = postorder[postorderEnd];
        int i = inorderStart;

        while(inorder[i]!=rootVal)
        {
            i++;
        }

        int left = i-inorderStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder,postorder,inorderStart,i-1,postorderStart,postorderStart+left-1);
        root.right = build(inorder,postorder,i+1,inorderEnd,postorderStart+left,postorderEnd-1);
        
        return root;
    }
}