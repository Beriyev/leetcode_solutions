class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefsum = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();
        int i;
        hash.put(0,-1);
        for(i=0;i<nums.length;i++)
        {
            prefsum+=nums[i];
            if(hash.containsKey(prefsum%k) && i-hash.get(prefsum%k)>=2)
            {
                return true;
            }
            if(!hash.containsKey(prefsum%k))
            {
                hash.put(prefsum%k,i);
            }
        }
        return false;
    }
}