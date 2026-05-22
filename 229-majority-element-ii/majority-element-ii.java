class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int flr = nums.length/3;
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> hash = new HashMap<>();
        int i;
        for(i=0;i<nums.length;i++)
        {
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);

            if(hash.get(nums[i])==flr+1)
            {
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}