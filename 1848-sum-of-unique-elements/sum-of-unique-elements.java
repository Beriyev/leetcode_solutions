class Solution {
    public int sumOfUnique(int[] nums) {
       HashMap<Integer,Integer> hash = new HashMap<>();
       int sum = 0;
       for(int num : nums)
       {
            hash.put(num,hash.getOrDefault(num,0)+1);
       }
       for(int num : hash.keySet())
       {
            if(hash.get(num)==1)
            {
                sum+=num;
            }
       } 
       return sum;
    }
}