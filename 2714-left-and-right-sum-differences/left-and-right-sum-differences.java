class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] ans = new int[nums.length];
        int sum = 0;
        int i;
        for(i=0;i<nums.length;i++)
        {
            if(i==0)
            {
                left[i] = sum;
            }
            else if(i>0)
            {
                left[i] = sum+nums[i-1];
                sum = left[i];
            }
        }
        sum = 0;
        for(i=nums.length-1;i>=0;i--)
        {
            if(i==nums.length-1)
            {
                right[i] = sum;
            }
            else if(i<nums.length-1)
            {
                right[i] = sum+nums[i+1];
                sum = right[i];
            }
        }
        for(i=0;i<nums.length;i++)
        {
            ans[i] = Math.abs(left[i]-right[i]);
        }
        return ans;
    }
}