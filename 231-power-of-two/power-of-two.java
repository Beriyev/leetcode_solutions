class Solution {
    public boolean isPowerOfTwo(int n) {
        int power = 1;
        if(n<=0)
        {
            return false;
        }
        if(n==1)
        {
            return true;
        }
        while(power>0&&power<n)
        {
            power = power<<1;
            if(power==n)
            {
                return true;
            }
        }
        return false;
    }
}