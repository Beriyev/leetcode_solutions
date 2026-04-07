class Solution {
    public int climbStairs(int n) {
        if(n==1 || n==2)
        {
            return n;
        }
        int prev1 = 1;
        int prev2 = 2;
        int i;
        int sum = 0;
        for(i=3;i<=n;i++)
        {
            sum = prev1 + prev2;
            prev1 = prev2;
            prev2 = sum;
        }
        return sum;
    }
}