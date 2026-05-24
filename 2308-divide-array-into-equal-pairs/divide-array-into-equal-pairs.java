class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int num : nums)
        {
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        for(int key : hash.keySet())
        {
            if(hash.get(key)%2!=0)
            {
                return false;
            }
        }
        return true;
    }
}