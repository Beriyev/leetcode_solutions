class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int i;
        long count = 0;
        for(i=0;i<nums.length;i++)
        {
            if(hash.containsKey(nums[i]-reverse(nums[i])))
            {
                count+=hash.get(nums[i]-reverse(nums[i]));
            }
            hash.put(nums[i]-reverse(nums[i]),hash.getOrDefault(nums[i]-reverse(nums[i]),0)+1);
        }
        return (int)(count%1000000007);
    }

    int reverse(int num)
    {
        int sum  = 0;
        while(num!=0)
        {
            sum = sum*10+num%10;
            num/=10;
        }
        return sum;
    }
}