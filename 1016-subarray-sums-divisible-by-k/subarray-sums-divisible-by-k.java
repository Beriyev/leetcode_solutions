class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefsum = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();
        int i;
        int count = 0;
        hash.put(0,1);
        for(i=0;i<nums.length;i++)
        {
            prefsum+=nums[i];
            if(hash.containsKey((prefsum%k+k)%k))
            {
                count+=hash.get((prefsum%k+k)%k);
            }
            hash.put((prefsum%k+k)%k,hash.getOrDefault((prefsum%k+k)%k,0)+1);
        }
        return count;
    }
}