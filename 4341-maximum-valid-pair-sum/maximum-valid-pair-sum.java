class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int i, j;
        int max = nums[0];
        int ans = 0;
        for(j=k;j<nums.length;j++)
        {
            ans = Math.max(ans,nums[j]+max);
            max = Math.max(max,nums[j-k+1]);
        }
        return ans;
    }
}