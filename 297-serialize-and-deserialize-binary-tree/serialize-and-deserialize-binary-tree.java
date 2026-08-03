/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    StringBuilder sb = new StringBuilder();
    int i = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        serial(root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        i=0;
        return deserial(arr);
    }

    void serial(TreeNode root)
    {
        if(root==null)
        {
            sb.append("Null");
            sb.append(",");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        serial(root.left);
        serial(root.right);
    }

    TreeNode deserial(String[] arr)
    {
        String ele = arr[i++];
        if(ele.equals("Null"))
        {
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(ele));
        head.left = deserial(arr);
        head.right = deserial(arr);
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));