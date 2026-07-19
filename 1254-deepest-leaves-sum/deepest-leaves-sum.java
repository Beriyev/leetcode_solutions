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
    public int deepestLeavesSum(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int sum = 0;
        int size;
        int i;
        TreeNode ele;

        queue.offer(root);

        while(!queue.isEmpty())
        {
            size = queue.size();
            sum = 0;

            for(i=0;i<size;i++)
            {
                ele = queue.poll();
                sum+=ele.val;
                if(ele.left!=null)
                {
                    queue.offer(ele.left);
                }
                if(ele.right!=null)
                {
                    queue.offer(ele.right);
                }
            }
        }
        return sum;
    }
}