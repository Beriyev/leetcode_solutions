class Solution {

    int[] parents;

    int find(int x)
    {
        if(parents[x]!=x)
        {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    public int findCircleNum(int[][] isConnected) {
        parents = new int[isConnected.length+1];
        int counter = isConnected.length;
        
        int i, j;

        for(i=0;i<=isConnected.length;i++)
        {
            parents[i] = i;
        }

        for(i=0;i<isConnected.length;i++)
        {
            for(j=0;j<isConnected.length;j++)
            {
                if(isConnected[i][j]==1)
                {
                    int leftParent = find(i);
                    int rightParent = find(j);
                    if(leftParent!=rightParent)
                    {
                        parents[rightParent] = leftParent;
                        counter--;
                    }
                }
            }
        }

        return counter;
    }
}