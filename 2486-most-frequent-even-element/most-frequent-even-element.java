class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int max = -1;
        int maxval = -1;
        int smaller = Integer.MAX_VALUE;
        for(int num : nums)
        {
            if(num%2==0)
            {
                hash.put(num,hash.getOrDefault(num,0)+1);
            }
        }
        for(int key : hash.keySet())
        {
            if(max==hash.get(key))
            {
                smaller = Math.min(smaller,key);
            }
            if(max<hash.get(key))
            {
                maxval = key;
                max = hash.get(key);
                smaller = key;
            }
        }

        if(smaller!=Integer.MAX_VALUE&&hash.get(smaller)==max)
        {
            return smaller;
        }
        return maxval;
    }
}