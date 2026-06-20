class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int i;
        int sum;

        for(i=0;i<nums.length/2;i++)
        {
            sum = nums[i]+nums[nums.length-i-1];
            if(sum>max)
            {
                max = sum;
            }
        }

        return max;
    }
}