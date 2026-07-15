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
    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int level = 0;
        int i, size;
        TreeNode ele;
        boolean ans = true;
        Integer prev;

        if(root.val%2==0)
        {
            return false;
        }

        queue.offer(root);

        while(!queue.isEmpty())
        {
            size = queue.size();
            prev = null;
            for(i=0;i<size;i++)
            {
                ele = queue.poll();
                if(level%2==1 && prev==null)
                {
                    if(ele.val%2==1)
                    {
                        return false;
                    }
                }
                if(level%2==1 && prev!=null)
                {
                    if(ele.val%2==1)
                    {
                        return false;
                    }
                    if(ele.val>=prev)
                    {
                        return false;
                    }
                }
                if(level%2==0 && prev==null)
                {
                    if(ele.val%2==0)
                    {
                        return false;
                    }
                }
                if(level%2==0 && prev!=null)
                {
                    if(ele.val%2==0)
                    {
                        return false;
                    }
                    if(ele.val<=prev)
                    {
                        return false;
                    }
                }
                prev = ele.val;
                if(ele!=null&&ele.left!=null)
                {
                    queue.offer(ele.left);
                }
                if(ele!=null&&ele.right!=null)
                {
                    queue.offer(ele.right);
                }
            }
            level++;   
        }
        return true;
    }
}