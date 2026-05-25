class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        int stone1, stone2;
        for(int stone : stones)
        {
            heap.add(stone);
        }
        while(heap.size()>1)
        {
            stone1 = heap.poll();
            stone2 = heap.poll();
            if(stone1!=stone2)
            {
                stone1-=stone2;
                heap.add(stone1);
            }
        }
        if(heap.size()==0)
        {
            return 0;
        }
        else
        {
            return heap.poll();
        }
    }
}