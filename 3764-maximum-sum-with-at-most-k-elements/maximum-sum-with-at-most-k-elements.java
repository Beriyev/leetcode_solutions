class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int counter = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i,j;

        for(i=0;i<rows;i++)
        {
            j = cols-1;
            counter = 0;
            Arrays.sort(grid[i]);
            while(counter<limits[i])
            {
                pq.offer(grid[i][j--]);
                counter++;
            }
        }

        long sum = 0;

        for(i=0;i<k;i++)
        {
            sum+=pq.poll();
        }

        return sum;
    }
}