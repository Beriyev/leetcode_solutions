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
    int count = 0;

    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[10];
        pseudo(root,freq);
        return count;
    }

    void pseudo(TreeNode root, int[] freq)
    {
        if(root==null)
        {
            return;
        }

        freq[root.val]++;

        if(root.left==null&&root.right==null)
        {
            int i;
            int oddCount = 0;
            for(i=0;i<freq.length;i++)
            {   
                if(freq[i]%2==1)
                {
                    oddCount++;
                }
            }
            if(oddCount<=1)
            {
                count++;
            }
        }

        pseudo(root.left,freq);
        pseudo(root.right,freq);

        freq[root.val]--;
    }
}