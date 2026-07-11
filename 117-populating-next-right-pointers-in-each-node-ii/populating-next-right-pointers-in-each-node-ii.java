/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node prev = null;
        Node curr = null;
        int size;
        int i;
        while(!queue.isEmpty())
        {
            size = queue.size();
            prev = null;
            for(i=0;i<size;i++)
            {
                curr = queue.poll();
                if(prev!=null)
                {
                    prev.next = curr;
                }
                prev = curr;
                if(curr!=null&&curr.left!=null) 
                { 
                    queue.offer(curr.left); 
                } 
                if(curr!=null&&curr.right!=null) 
                { 
                    queue.offer(curr.right); 
                }
            }
        }
        return root;
    }
}