class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i;
        
        for(i=0;i<citations.length;i++)
        {
            if(citations[i]>=citations.length-i)
            {
                return citations.length-i;
            }
        }
        return 0;
    }
}