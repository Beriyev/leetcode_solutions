class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();

        int dist = 1;

        if(grid[grid.length-1][grid[0].length-1]==1)
        {
            return -1;
        }

        if(grid.length==1&&grid[0].length==1)
        {
            return 1;
        }

        if(grid[0][0]==1)
        {
            return -1;
        }

        queue.offer(new int[]{0,0});
        grid[0][0] = 1;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            int i;

            for(i=0;i<size;i++)
            {
                int[] pair = queue.poll();
                if(pair[0]==grid.length-1&&pair[1]==grid[0].length-1)
                {
                    return dist;
                }
                int x = pair[0];
                int y = pair[1];
                enqueue(queue,x-1,y,grid);
                enqueue(queue,x+1,y,grid);
                enqueue(queue,x,y-1,grid);
                enqueue(queue,x,y+1,grid);
                enqueue(queue,x-1,y-1,grid);
                enqueue(queue,x-1,y+1,grid);
                enqueue(queue,x+1,y-1,grid);
                enqueue(queue,x+1,y+1,grid);
            }

            dist++;
        }

        return -1;
    }

    void enqueue(LinkedList<int[]> queue, int x, int y, int[][] grid)
    {
        if(x<0||x>=grid.length||y<0||y>=grid[0].length)
        {
            return;
        }
        int[] pair = new int[]{x,y};
        if(grid[x][y]==0)
        {
            queue.offer(pair);
        }
        grid[x][y] = 1;
    }
}