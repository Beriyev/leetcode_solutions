class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        int i;

        for(i=0;i<gain.length;i++)
        {
            sum+=gain[i];
            if(sum>max)
            {
                max = sum;
            }
        }
        return max;
    }
}