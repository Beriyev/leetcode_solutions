class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int i;
        int count = 0;
        for(i=0;i<intervals.length;i++)
        {
            Arrays.sort(intervals,(a,b)->{
                if(a[0]!=b[0])
                {
                    return a[0]-b[0];
                }
                else
                {
                    return b[1]-a[1];
                }
            });
        }
        int max = 0;
        for(i=0;i<intervals.length;i++)
        {
            if(intervals[i][1]>max)
            {
                max = intervals[i][1];
            }
            else
            {
                count++;
            }
        }
        return intervals.length-count;
    }
}