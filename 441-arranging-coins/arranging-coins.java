class Solution {
    public int arrangeCoins(int n) {
        int count = 0;
        int i = 1;
        while(n!=0)
        {
            if(n-i<0)
            {
                return i-1;
            }
            n = n-i;
            i++;
        }
        return i-1;
    }
}