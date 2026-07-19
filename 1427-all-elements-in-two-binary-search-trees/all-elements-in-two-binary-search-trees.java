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
    List<Integer> root1List = new ArrayList<>();
    List<Integer> root2List = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        get(root1,root1List);
        get(root2,root1List);
        root1List.addAll(root2List);
        Collections.sort(root1List);
        return root1List;
    }

    void get(TreeNode root, List list)
    {
        if(root==null)
        {
            return;
        }
        get(root.left, list);
        list.add(root.val);
        get(root.right, list);
    }
}