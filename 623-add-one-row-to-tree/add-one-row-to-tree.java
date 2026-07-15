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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currDepth = 1;
        int i;
        TreeNode newNode;
        TreeNode ele;
        int size;
        TreeNode leftNode = null;
        TreeNode rightNode = null;

        if(depth==1)
        {
            TreeNode newHead = new TreeNode(val);
            newHead.left = root;
            return newHead;
        }

        while(!queue.isEmpty())
        {
            size = queue.size();
            if(currDepth==depth-1)
            {
                for(i=0;i<size;i++)
                {
                    ele = queue.poll();
                    leftNode = ele.left;
                    rightNode = ele.right;
                    ele.left = new TreeNode(val);
                    ele.right = new TreeNode(val);
                    ele.left.left = leftNode;
                    ele.right.right = rightNode;
                }
                return root;
            }
            else
            {
                for(i=0;i<size;i++)
                {
                    ele = queue.poll();
                    if(ele!=null&&ele.left!=null)
                    {
                        queue.offer(ele.left);
                    }
                    if(ele!=null&&ele.right!=null)
                    {
                        queue.offer(ele.right);
                    }
                }
            }
            currDepth++;
        }
        return root;
    }
}