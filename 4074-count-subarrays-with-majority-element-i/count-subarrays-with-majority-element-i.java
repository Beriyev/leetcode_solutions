class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int i, j;
        int freq = 0;
        int count = 0;
        for(i=0;i<nums.length;i++)
        {
            freq = 0;
            for(j=i;j<nums.length;j++)
            {
                if(nums[j]==target)
                {
                    freq++;
                }
                if(2*freq>j-i+1)
                {
                    count++;
                }
            }
        }

        return count;
    }
}