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
    public TreeNode reverseOddLevels(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode first, last;
        int size;
        int i;
        TreeNode ele;
        int level = 0;
        int temp;

        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            size = queue.size();
            if(level%2==1)
            {
                LinkedList<TreeNode> reverse = new LinkedList<>(queue);
                for(i=0;i<size/2;i++)
                {
                    first = reverse.removeFirst();
                    last = reverse.removeLast();
                    temp = first.val;
                    first.val = last.val;
                    last.val = temp;
                }
            }
            for(i=0;i<size;i++)
            {
                ele = queue.poll();
                if(ele!=null&&ele.left!=null)
                {
                    queue.add(ele.left);
                }
                if(ele!=null&&ele.right!=null)
                {
                    queue.add(ele.right);
                }
            }
            level++;
        }

        return root;
    }
}