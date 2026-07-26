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
class BSTIterator {
    int idx = 0;
    ArrayList<Integer> list;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorder(root,list);
    }
    
    public int next() {
        return list.get(idx++);
    }
    
    public boolean hasNext() {
        if(idx<list.size())
        {
            return true;
        }
        return false;
    }

    void inorder(TreeNode head, ArrayList<Integer> list)
    {
        if(head==null)
        {
            return;
        }
        inorder(head.left,list);
        list.add(head.val);
        inorder(head.right,list);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */