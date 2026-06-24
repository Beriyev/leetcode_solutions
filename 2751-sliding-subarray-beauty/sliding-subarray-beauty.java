class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int left = 0;
        int right = k-1;
        int[] freq = new int[51];
        int count = 0;
        int counter = 0;

        int[] ans = new int[nums.length-k+1];
        int i, j;
        j = 0;

        for(i=0;i<=right;i++)
        {
            if(nums[i]<0)
            {
                count++;
                freq[-1*nums[i]]++;
            }
        }

        while(right<nums.length)
        {
            if(count<x)
            {
                ans[j++] = 0;
            }
            else
            {
                counter = 0;
                for(i=50;i>0;i--)
                {
                    counter+=freq[i];
                    if(counter>=x)
                    {
                        break;
                    }
                }
                ans[j++] = -1*i;
            }

            if(right==nums.length-1)
            {
                break;
            }
            if(nums[left]<0)
            {
                freq[-1*nums[left]]--;
                count--;
            }
            left++;
            right++;
            if(nums[right]<0)
            {
                freq[-1*nums[right]]++;
                count++;
            }
        }
        return ans;
    }
}