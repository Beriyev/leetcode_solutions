class Solution {
    public int longestSubarray(int[] nums) {
        int zerocount = 0;
        int left = 0;
        int right = 0;
        int max = 0;

        for(right=0;right<nums.length;right++)
        {
            if(nums[right]==0)
            {
                zerocount++;
            }
            while(zerocount>1)
            {
                if(nums[left]==0)
                {
                    zerocount--;
                }
                left++;
            }
            if(right-left>max)
            {
                max = right-left;
            }
        }
        return max;
    }
}