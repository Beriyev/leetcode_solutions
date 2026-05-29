class Solution {
    public long countBadPairs(int[] nums) {
        long count = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();
        int i;
        long m;
        for(i=0;i<nums.length;i++)
        {
            if(!hash.containsKey(nums[i]-i))
            {
                hash.put(nums[i]-i,1);
            }
            else
            {
                hash.put(nums[i]-i,hash.get(nums[i]-i)+1);
            }
        }
        for(int value : hash.values())
        {
            m = (long) value*(value-1)/2;
            count+=m;
        }
        long n = nums.length;
        long size = n*(n-1)/2;
        return size-count;
    }
}