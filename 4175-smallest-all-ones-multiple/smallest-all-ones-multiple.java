class Solution {
    public int minAllOneMultiple(int k) {
        int count = 1;
        int rem = 0;

        while(count<=k)
        {
            rem = (rem*10+1)%k;
            if(rem==0)
            {
                return count;
            }
            count++;
        }

        return -1;
    }
}