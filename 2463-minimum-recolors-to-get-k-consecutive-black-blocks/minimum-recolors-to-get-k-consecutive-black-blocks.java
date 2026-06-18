class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left, right;
        left = 0;
        right = 0;
        int counter = 0;
        int min = blocks.length();
        int i,j;
        for(i=0;i<=blocks.length()-k;i++)
        {
            counter = 0;
            for(j=i;j<i+k;j++)
            {
                if(blocks.charAt(j)=='W')
                {
                    counter++;
                }
            }
            if(counter<min)
            {
                min = counter;
            }
        }
        return min;
    }
}