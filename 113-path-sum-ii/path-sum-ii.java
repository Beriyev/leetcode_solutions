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
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> currPath = new ArrayList<>();
        backtrack(root,targetSum,currPath);
        return ans;
    }

    void backtrack(TreeNode root, int targetSum, ArrayList<Integer> currPath)
    {
        if(root==null)
        {
            return;
        }

        currPath.add(root.val);

        if(root.left==null&&root.right==null&&targetSum==root.val)
        {
            ans.add(new ArrayList<>(currPath));
        }

        backtrack(root.left,targetSum-root.val,currPath);
        backtrack(root.right,targetSum-root.val,currPath);

        currPath.remove(currPath.size()-1);
    }
}