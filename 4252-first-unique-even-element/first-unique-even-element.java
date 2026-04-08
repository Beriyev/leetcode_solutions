class Solution {
    public int firstUniqueEven(int[] nums) {
        int i;
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(i=0;i<nums.length;i++)
        {
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
        }
        for(int key : nums)
        {
            if(key%2==0 && hash.get(key)==1)
            {
                return key;
            }
        }
        return -1;
    }
}