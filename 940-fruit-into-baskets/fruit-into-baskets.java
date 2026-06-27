class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int i;
        int left = 0;
        int right = 0;
        int max = 0;

        for(right=0;right<fruits.length;right++)
        {
            hash.put(fruits[right],hash.getOrDefault(fruits[right],0)+1);

            while(hash.size()>2)
            {
                hash.put(fruits[left],hash.get(fruits[left])-1);
                if(hash.get(fruits[left])==0)
                {
                    hash.remove(fruits[left]);
                }
                left++;
            }

            max = Math.max(right-left+1,max);
        } 
        return max;
    }
}