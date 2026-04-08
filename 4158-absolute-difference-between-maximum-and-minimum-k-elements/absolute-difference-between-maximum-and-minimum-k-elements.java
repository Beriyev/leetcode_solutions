class Solution {
    public int absDifference(int[] nums, int k) {
        int highsum=0;
        int lowsum=0;
        int i;
        Arrays.sort(nums);
        for(i=0;i<k;i++)
        {
            lowsum += nums[i];
            highsum += nums[nums.length-i-1];
        }
        return highsum - lowsum;
    }
}