class Solution {
    int clusters;
    int redundancies = 0;

    int[] parents;

    int find(int x)
    {
        if(parents[x]!=x)
        {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    public int makeConnected(int n, int[][] connections) {
        parents = new int[n];
        int i;
        clusters = n;

        for(i=0;i<n;i++)
        {
            parents[i] = i;
        }

        for(int[] connection : connections)
        {
            int leftParent = find(connection[0]);
            int rightParent = find(connection[1]);

            if(leftParent == rightParent)
            {
                redundancies++;
                continue;
            }

            parents[rightParent] = leftParent;
            clusters--;
        }

        if(clusters-1>redundancies)
        {
            return -1;
        }
        else
        {
            return clusters-1;
        }
    }
}