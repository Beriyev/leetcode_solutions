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

    HashMap<Integer,Integer> hash = new HashMap<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int max = -1;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int f : hash.values())
        {
            if(f>max)
            {
                max = f;
            }
        }
        for(int key : hash.keySet())
        {
            if(hash.get(key)==max)
            {
                ans.add(key);
            }
        }
        int s = ans.size();
        int[] arr = new int[s];
        for(int i = 0;i<s;i++)
        {
            arr[i] = ans.get(i);
        }
        return arr;
    }

    public void dfs(TreeNode root)
    {
        if(root==null)
        {
            return;
        }

        hash.put(root.val,hash.getOrDefault(root.val,0)+1);

        if(root.left!=null)
        {
            dfs(root.left);
        }
        if(root.right!=null)
        {
            dfs(root.right);
        }
    }
}