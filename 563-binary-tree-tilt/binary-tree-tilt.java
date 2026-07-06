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
    int ans = 0;
    public int findTilt(TreeNode root) {
        tilt(root);
        return ans;
    }

    int tilt(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left = tilt(root.left);
        int right = tilt(root.right);
        ans+=Math.abs(left-right);
        return root.val+left+right;
    }
}