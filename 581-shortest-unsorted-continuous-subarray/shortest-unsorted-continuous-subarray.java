class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        int i;
        int leftidx, rightidx;
        leftidx = nums.length;
        rightidx = -1;

        for(i=0;i<nums.length;i++)
        {
            while(!left.isEmpty()&&nums[left.peek()]>nums[i])
            {
                leftidx = Math.min(leftidx,left.pop());
            }
            left.push(i);
        }

        for(i=nums.length-1;i>=0;i--)
        {
            while(!right.isEmpty()&&nums[right.peek()]<nums[i])
            {
                rightidx = Math.max(rightidx,right.pop());
            }
            right.push(i);
        }

        if(leftidx==nums.length)
        {
            return 0;
        }

        return rightidx-leftidx+1;
    }
}