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
        for(i=0;i<nums.length;i++)
        {
            counter = 2;
            if(i==0||i==1)
            {
                prime[i] = false;
                continue;
            }
            if(!prime[i])
            {
                continue;
            }
            prod = i*counter;
            while(prod<=high)
            {
                prime[prod] = false;
                counter++;
                prod=i*counter;
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