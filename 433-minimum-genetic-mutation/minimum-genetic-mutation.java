class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> hash = new HashSet<>();
        int i,j; 
        int steps = 0;
        String choices = "ACGT";
        char original;

        for(String mutation : bank)
        {
            hash.add(mutation);
        }

        LinkedList<String> queue = new LinkedList<>();

        HashSet<String> visited = new HashSet<>();

        queue.offer(startGene);
        visited.add(startGene);

        while(!queue.isEmpty())
        {
           int size = queue.size();
           for(j=0;j<size;j++)
           {
                String str = queue.poll();

                if(str.equals(endGene))
                {
                    return steps;
                }

                char[] arr = str.toCharArray();
                for(i=0;i<arr.length;i++)
                {
                    original = arr[i];
                    for(char letter : choices.toCharArray())
                    {
                        arr[i] = letter;
                        String mutation = new String(arr);
                        if(hash.contains(mutation) && !visited.contains(mutation))
                        {
                            queue.offer(mutation);
                            visited.add(mutation);
                        }
                    }
                    arr[i] = original;
                }
           }
           steps++;
        }

        return -1;
    }
}