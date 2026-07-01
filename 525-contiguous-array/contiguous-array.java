class Solution {
    public int findMaxLength(int[] nums) {
        int i;
        int len = 0;
        int max = 0;

        for(i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                nums[i] = -1;
            }
        }

        int prefsum = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();
        hash.put(0,-1);

        for(i=0;i<nums.length;i++) 
        {
            prefsum+=nums[i];
            if(hash.containsKey(prefsum)&&i-hash.get(prefsum)>max)
            {
                max=i-hash.get(prefsum);
            }
            if(!hash.containsKey(prefsum))
            {
                hash.put(prefsum,i);
            }
        }
        return max;
    }
}