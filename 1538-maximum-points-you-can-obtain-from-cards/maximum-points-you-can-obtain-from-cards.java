class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int windowpoints = 0;
        int left = 0;
        int right;
        int i;
        int n = cardPoints.length;
        int total = 0;
        int max = 0;

        for(i=0;i<cardPoints.length;i++)
        {
            total+=cardPoints[i];
        }

        for(i=0;i<n-k;i++)
        {
            windowpoints+=cardPoints[i];
        }

        right = n-k-1;

        while(right<cardPoints.length)
        {
            if(total-windowpoints>max)
            {
                max = total-windowpoints;
            }

            if(right==cardPoints.length-1)
            {
                break;
            }

            windowpoints-=cardPoints[left];
            left++;
            right++;
            windowpoints+=cardPoints[right];
        }
        
        return max;
    }
}