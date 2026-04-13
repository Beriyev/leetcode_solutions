class Solution {
    public int heightChecker(int[] heights) {
        int[] heightscopy = new int[heights.length];
        int i;
        for(i=0;i<heights.length;i++)
        {
            heightscopy[i] = heights[i];
        }
        int count = 0;
        Arrays.sort(heights);
        for(i=0;i<heights.length;i++)
        {
            if(heightscopy[i]!=heights[i])
            {
                count++;
            }
        }
        return count;
    }
}