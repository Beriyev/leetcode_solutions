class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        int i;
        HashMap<Integer,List<Integer>> hash = new HashMap<>();

        for(i=0;i<groupSizes.length;i++)
        {
            if(!hash.containsKey(groupSizes[i]))
            {
                hash.put(groupSizes[i], new ArrayList<>());
            }
            hash.get(groupSizes[i]).add(i);
            if(hash.get(groupSizes[i]).size()==groupSizes[i])
            {
                ans.add(new ArrayList<>(hash.get(groupSizes[i])));
                hash.get(groupSizes[i]).clear();
            }
        }
        return ans;
    }
}