class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int i, j;
        int[] ans = new int[nums.length];
        for(i=0;i<nums.length;i++)
        {
            ans[i] = 0;
        }

        for(i=0;i<nums.length;i++)
        {
            for(j=0;j<nums.length;j++)
            {
                if(nums[j]<nums[i])
                {
                    ans[i]++;
                }
            }
        }

        return ans;
    }
}