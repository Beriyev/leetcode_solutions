class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colour = new int[graph.length];
        LinkedList<Integer> queue = new LinkedList<>();
        int i;

        for(i=0;i<colour.length;i++)
        {
            if(colour[i]==0)
            {
                queue.offer(i);
                colour[i] = 1;

                while(!queue.isEmpty())
                {
                    int ele = queue.poll();
                    for(int neighbour : graph[ele])
                    {
                        if(colour[neighbour]==0)
                        {
                            if(colour[ele]==1)
                            {
                                colour[neighbour] = 2;
                            }
                            else if(colour[ele]==2)
                            {
                                colour[neighbour] = 1;
                            }
                            queue.offer(neighbour);
                        }
                        else if(colour[neighbour]==colour[ele])
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}