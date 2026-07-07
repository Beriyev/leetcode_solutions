class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] numscopy = Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        int i;
        int start = -1;
        int end = -1;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]!=numscopy[i])
            {
                start = i;
                break;
            }
        }
        for(i=nums.length-1;i>=0;i--)
        {
            if(nums[i]!=numscopy[i])
            {
                end = i;
                break;
            }
        }
        if(start==-1)
        {
            return 0;
        }
        return end-start+1;
    }
}