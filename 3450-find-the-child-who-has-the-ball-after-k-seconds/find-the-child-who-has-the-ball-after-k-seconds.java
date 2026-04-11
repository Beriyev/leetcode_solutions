
class Solution {
    public int numberOfChild(int n, int k) {
        int i = 0;
        int j = 0;
        int reverse = 0;
        int child = 0;
        for(i=0;i<=k;i++)
        {
            if(j==0)
            {
                reverse = 0;
            }
            else if(j==n-1)
            {
                reverse = 1;
            }
            if(reverse==0)
            {
                child = j++;
            }
            if(reverse==1)
            {
                child = j--;
            }
        }
        return child;
    }
}