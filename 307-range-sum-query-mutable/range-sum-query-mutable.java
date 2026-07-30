class NumArray {

    Node root;

    public NumArray(int[] nums) {
        root = build(nums,0,nums.length-1);
    }
    
    public void update(int index, int val) {
        update(root,index,val);
    }

    void update(Node root, int index, int val)
    {
        if(root.low==root.high)
        {
            root.sum = val;
            return;
        }
        if(index<root.low || index>root.high)
        {
            return;
        }
        int mid = root.low+(root.high-root.low)/2;
        if(index<=mid)
        {
            update(root.left,index,val);
        }
        else
        {
            update(root.right,index,val);
        }
        root.sum = root.left.sum+root.right.sum;
    }   

    public int sumRange(int left, int right) {
       return sum(root,left,right);
    }

    int sum(Node root, int left, int right)
    {
        if(root==null)
        {
            return 0;
        }

        if(left>root.high || right < root.low)
        {
            return 0;
        }
        else if(left<=root.low&&right>=root.high)
        {
            return root.sum;
        }
        else
        {
            return sum(root.left,left,right)+sum(root.right,left,right);
        }
    } 

    Node build(int[] nums, int left, int right)
    {
        if(left==right)
        {
            Node node = new Node(left,right);
            node.sum = nums[left];
            return node;
        }

        int mid = left+(right-left)/2;

        Node node = new Node(left,right);

        node.left = build(nums,left,mid);
        node.right = build(nums,mid+1,right);

        node.sum = node.left.sum+node.right.sum;

        return node;
    }
}

class Node
{
    int low;
    int high;
    int sum;

    Node left;
    Node right;

    Node(int low, int high)
    {
        this.low = low;
        this.high = high;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */