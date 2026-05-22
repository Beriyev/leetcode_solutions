class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int flr = (int) Math.floor(nums.length/3);
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> hash = new HashMap<>();
        int i;
        for(i=0;i<nums.length;i++)
        {
            if(!hash.containsKey(nums[i])||hash.get(nums[i])!=-1)
            {
                hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
            }
            if(hash.get(nums[i])>flr)
            {
                ans.add(nums[i]);
                hash.put(nums[i],-1);
            }
        }
        return ans;
    }
}