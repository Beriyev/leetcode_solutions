class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo, hi;
        int mid = 0;
        long sum = 0;
        lo = 1;
        hi = 0;
        int i;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]>hi)
            {
                hi = nums[i];
            }
        }

        while(lo<=hi)
        {
            sum = 0;
            mid = lo+(hi-lo)/2;
            for(i=0;i<nums.length;i++)
            {
                sum+=Math.ceil((double)nums[i]/mid);
            }
            if(sum<=threshold)
            {
                hi = mid-1;
            }
            else
            {
                lo = mid+1;
            }
        }
        return lo;
    }
}