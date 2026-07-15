class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddsum = 0;
        int count = 0;
        int evensum = 0;
        int o = 1;
        int e = 2;
        int i = 1;
        for(i=0;i<n;i++)
        {
            oddsum+=o;
            o+=2;
        }
        for(i=0;i<n;i++)
        {
            evensum+=e;
            e+=2;
        }
        return gcd(evensum,oddsum);
    }

    int gcd(int a, int b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a%b);
    }
}