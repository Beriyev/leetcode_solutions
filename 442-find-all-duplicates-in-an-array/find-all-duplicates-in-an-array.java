class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i;
        ArrayList<Integer> ans = new ArrayList<>();
        for(i=0;i<nums.length;i++)
        {
            if(nums[Math.abs(nums[i])-1]<0)
            {
                ans.add(Math.abs(nums[i]));
            }
            nums[Math.abs(nums[i])-1] = nums[Math.abs(nums[i])-1]*-1;
        }
        return ans;
    }
}