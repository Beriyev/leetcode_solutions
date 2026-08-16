class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,ArrayList<String>> graph = new HashMap<>();
        HashMap<String,Integer> indegree = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();

        int i, j;

        for(i=0;i<recipes.length;i++)
        {
            indegree.put(recipes[i],ingredients.get(i).size());
            for(String ingredient : ingredients.get(i))
            {
                if(!graph.containsKey(ingredient))
                {
                    graph.put(ingredient, new ArrayList<>());
                }
                graph.get(ingredient).add(recipes[i]);
            }
        }

        LinkedList<String> queue = new LinkedList<>();

        for(String supply : supplies)
        {
            queue.offer(supply);
        }

        while(!queue.isEmpty())
        {
            String supply = queue.poll();
            if(!graph.containsKey(supply))
            {
                continue;
            }
            for(String recipe : graph.get(supply))
            {
                indegree.put(recipe,indegree.get(recipe)-1);
                if(indegree.get(recipe)==0)
                {
                    queue.offer(recipe);
                    ans.add(recipe);
                }
            }
        }

        return ans;
    }
}