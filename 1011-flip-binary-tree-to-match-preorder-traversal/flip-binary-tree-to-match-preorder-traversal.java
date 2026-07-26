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
    int idx = 0;
    ArrayList<Integer> ans = new ArrayList<>();
    int possible = 1;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        flip(root,voyage);
        if(possible==0)
        {
            ArrayList<Integer> returnVal = new ArrayList<>();
            returnVal.add(-1);
            return returnVal;
        }
        return ans;
    }

    void flip(TreeNode root, int[] voyage)
    {
        if(root==null)
        {
            return;
        }
        if(idx==voyage.length)
        {
            return;
        }

        if(root.val!=voyage[idx])
        {
            possible = 0;
            return;
        }

        idx++;

        if(idx==voyage.length)
        {
            return;
        }

        if(root.left==null&&root.right==null)
        {
            return;
        }

        if(root.left==null)
        {
            flip(root.right,voyage);
        }
        else if(root.left!=null&&root.left.val==voyage[idx])
        {
            flip(root.left,voyage);
            flip(root.right,voyage);
        }
        else if(root.right!=null&&root.right.val==voyage[idx])
        {
            TreeNode temp = root.left;
            ans.add(root.val);
            root.left = root.right;
            root.right = temp;
            flip(root.left,voyage);
            flip(root.right,voyage);
        }
        else
        {
            possible = 0;
            return;
        }
    }
}