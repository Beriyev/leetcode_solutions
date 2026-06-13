class Solution {
    public long splitArray(int[] nums) {
        int counter = 2;
        int prod = 1;
        int high = nums.length-1;
        boolean[] prime = new boolean[nums.length];
        int i;
        for(i=0;i<nums.length;i++)
        {
            prime[i] = true;
        }
        prime[0] = false;
        if(nums.length>1)
        {
            prime[1] = false;
            for(i=2;i*i<=high;i++)
            {
                if(!prime[i])
                {
                    continue;
                }
                prod = i*i;
                while(prod<=high)
                {
                    prime[prod] = false;
                    prod+=i;
                }
            }
        }
        
        long primesum = 0;
        long nonprimesum = 0;
        for(i=0;i<nums.length;i++)
        {
            if(prime[i])
            {
                primesum+=nums[i];
            }
            else
            {
                nonprimesum+=nums[i];
            }
        }
        return Math.abs(nonprimesum-primesum);
    }
}