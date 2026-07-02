class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int i;
        int prefsum = 0;
        int count = 0;
        hash.put(0,1);
        for(i=0;i<nums.length;i++)
        {
            prefsum+=nums[i];
            if(hash.containsKey(prefsum-goal))
            {
                count+=hash.get(prefsum-goal);
            }
            hash.put(prefsum,hash.getOrDefault(prefsum,0)+1);
        }
        return count;
    }
}