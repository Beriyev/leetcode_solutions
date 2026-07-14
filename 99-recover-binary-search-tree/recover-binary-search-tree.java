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
    ArrayList<Integer> list = new ArrayList<>();
    int i = 0;

    public void recoverTree(TreeNode root) {
        traverse(root);
        Collections.sort(list);
        fillIn(root);
    }

    void traverse(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }

    void fillIn(TreeNode root)
    {
        if(root==null)
        {
            return;
        }

        fillIn(root.left);
        root.val = list.get(i++);
        fillIn(root.right);
    }
}