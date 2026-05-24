class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int hi = 0;
        int lo = 0;
        int closest = nums[0]+nums[1]+nums[2];
        int sum;

        for(i=0;i<nums.length-2;i++)
        {
            lo = i+1;
            hi = nums.length-1;
            while(lo<hi)
            {   
                sum = nums[i]+nums[lo]+nums[hi];
                if(Math.abs(target-sum)<Math.abs(closest-target))
                {
                    closest = sum;
                }
                if(sum>target)
                {
                    hi--;
                }
                else
                {
                    lo++;
                }
            }
        }
        return closest;
    }
}