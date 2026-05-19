class Solution {
    public int[] sortedSquares(int[] nums) {
        int i;
        int[] ans = new int[nums.length];
        for(i=0;i<nums.length;i++)
        {
            ans[i] = nums[i]*nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}