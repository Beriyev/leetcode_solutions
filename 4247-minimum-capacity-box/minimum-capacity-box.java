class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int i;
        int mincap=-1;

        for(i=0;i<capacity.length;i++)
        {
            if(itemSize<=capacity[i])
            {
                if(mincap==-1)
                {
                    mincap = i;
                }
                if(capacity[i]<capacity[mincap])
                {
                    mincap = i;
                }
            }
        }
        return mincap;
    }
}