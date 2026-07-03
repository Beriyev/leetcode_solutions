class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int i;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0)
            {
                nums[i] = 0;
            }
            else
            {
                nums[i] = 1;
            }
        }
        HashMap<Integer,Integer> hash = new HashMap<>();
        int prefsum = 0;
        int count = 0;
        hash.put(0,1);
        for(i=0;i<nums.length;i++)
        {
            prefsum+=nums[i];
            if(hash.containsKey(prefsum-k))
            {
                count+=hash.get(prefsum-k);
            }
            hash.put(prefsum,hash.getOrDefault(prefsum,0)+1);
        }
        return count;
    }
}