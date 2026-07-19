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
    List<Integer> ans = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        get(root1,root1List);
        get(root2,root2List);
        int i=0;
        int j=0;
        while(i<root1List.size()&&j<root2List.size())
        {
            if(root1List.get(i)<root2List.get(j))
            {
                ans.add(root1List.get(i));
                i++;
            }
            else
            {
                ans.add(root2List.get(j));
                j++;
            }
        }
        if(j==root2List.size())
        {
            while(i<root1List.size())
            {
                ans.add(root1List.get(i));
                i++;
            }
        }
        else
        {
            while(j<root2List.size())
            {
                ans.add(root2List.get(j));
                j++;
            }
        }
        return ans;
    }

    void get(TreeNode root, List<Integer> list)
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