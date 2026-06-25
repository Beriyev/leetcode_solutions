class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int i;
        int left = 0;
        int right = k-1;
        long sum = 0;
        long max = 0;

        for(i=0;i<=right;i++)
        {
            sum+=nums[i];
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
        }

        if(hash.size()==k)
        {
            max = sum;
        }


        for(right=k;right<nums.length;right++)
        {
            sum+=nums[right];
            hash.put(nums[right],hash.getOrDefault(nums[right],0)+1);

            if(right-left+1>k)
            {
                sum-=nums[left];
                hash.put(nums[left],hash.get(nums[left])-1);
                if(hash.get(nums[left])==0)
                {
                    hash.remove(nums[left]);
                }
                left++;
            }

            if(right-left+1==k && hash.size()==k)
            {
                max = Math.max(sum,max);
            }
        }

        return max;     
    }
}