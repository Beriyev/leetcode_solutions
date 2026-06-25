class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int left, right;
        left = 0;
        right = 0;
        int max = 0;
        int sum = 0;

        int i;

        for(right=0;right<nums.length;right++)
        {
            if(!set.contains(nums[right]))
            {
                set.add(nums[right]);
                sum+=nums[right];
            }
            else
            {
                while(set.contains(nums[right])&&left<=right)
                {
                    sum-=nums[left];
                    set.remove(nums[left]);
                    left++;
                }
                set.add(nums[right]);
                sum+=nums[right];
            }
            max = Math.max(sum,max);
        }
        return max;
    }
}