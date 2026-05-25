class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hash = new HashMap<>();
        for(String word : words)
        {
            hash.put(word,hash.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>(
            (a,b) -> {if(hash.get(a)==hash.get(b))
            {
                return a.compareTo(b);
            }
            return hash.get(b) - hash.get(a);
            });
        for(String word : hash.keySet())
        {
            heap.add(word);
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            list.add(heap.poll());
        }
        return list;
    }
}