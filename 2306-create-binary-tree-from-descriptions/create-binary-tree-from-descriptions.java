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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> hash = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int root=0;
        int parents = descriptions.length;
        TreeNode child;
        TreeNode parent;
        int i, j;
        for(i=0;i<parents;i++)
        {
            set.add(descriptions[i][1]);
        }
        for(i=0;i<parents;i++)
        {
            if(!set.contains(descriptions[i][0]))
            {
                root = descriptions[i][0];
            }
        }
        for(i=0;i<parents;i++)
        {
            if(hash.containsKey(descriptions[i][0]))
            {
                parent = hash.get((descriptions[i][0]));
                if(hash.containsKey(descriptions[i][1]))
                {
                    child = hash.get(descriptions[i][1]);
                }
                else
                {
                    child = new TreeNode(descriptions[i][1]);
                    hash.put(descriptions[i][1],child);
                }
                if(descriptions[i][2]==1)
                {
                    parent.left = child;
                }
                else
                {
                    parent.right = child;
                }
                hash.put(descriptions[i][0],parent);
            }
            else
            {
                parent = new TreeNode(descriptions[i][0]);
                if(hash.containsKey(descriptions[i][1]))
                {
                    child = hash.get(descriptions[i][1]);
                }
                else
                {
                    child = new TreeNode(descriptions[i][1]);
                    hash.put(descriptions[i][1],child);
                }
                if(descriptions[i][2]==1)
                {
                    parent.left = child;
                }
                else
                {
                    parent.right = child;
                }
                hash.put(descriptions[i][0],parent); 
            }      
        }
        return hash.get(root);
    }
}