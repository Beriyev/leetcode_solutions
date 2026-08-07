class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer>[] reversed = new ArrayList[graph.length];
        int[] outdegree = new int[graph.length];

        int i, j;

        for(i=0;i<graph.length;i++)
        {
            reversed[i] = new ArrayList<>();
        }

        for(i=0;i<graph.length;i++)
        {
            for(int node : graph[i])
            {
                reversed[node].add(i);
            }
        }

        for(i=0;i<graph.length;i++)
        {
            outdegree[i] = graph[i].length;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(i=0;i<outdegree.length;i++)
        {
            if(outdegree[i]==0)
            {
                queue.add(i);
                ans.add(i);
            }
        }

        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(i=0;i<size;i++)
            {
                int element = queue.poll();
                for(int node : reversed[element])
                {
                    outdegree[node]--;
                    if(outdegree[node]==0)
                    {
                        queue.add(node);
                        ans.add(node);
                    }
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}