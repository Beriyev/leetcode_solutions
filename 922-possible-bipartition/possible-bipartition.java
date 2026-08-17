class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] colours = new int[n+1];
        HashMap<Integer,ArrayList<Integer>> hash = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int i = 1;
        for(i=1;i<=n;i++)
        {
            hash.put(i,new ArrayList<>());
        }
        for(int[] dislike : dislikes)
        {
            hash.get(dislike[0]).add(dislike[1]);
            hash.get(dislike[1]).add(dislike[0]);
        }

        for(i=1;i<=n;i++)
        {
            if(colours[i]==0)
            {
                colours[i] = 1;
                queue.offer(i);
            }
            while(!queue.isEmpty())
            {
                int ele = queue.poll();
                for(int neighbour : hash.get(ele))
                {
                    if(colours[neighbour]==colours[ele])
                    {
                        return false;
                    }
                    if(colours[neighbour]==0)
                    {
                        if(colours[ele]==1)
                        {
                            colours[neighbour] = 2;
                        }
                        else
                        {
                            colours[neighbour] = 1;
                        }
                        queue.offer(neighbour);
                    }
                }
            }
        }
        return true;
    }
}