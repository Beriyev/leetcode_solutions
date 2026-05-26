class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int count = 0;
        int i,j;
        int idx = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)->{
                if(!hash.get(a).equals(hash.get(b)))
                {
                    return hash.get(a)-hash.get(b);
                }
            return a-b;
            }
            );
        for(i=0;i<mat.length;i++)
        {
            for(j=0;j<mat[0].length;j++)
            {
                count+=mat[i][j];
            }
            hash.put(idx,count);
            pq.add(idx);
            count = 0;
            idx++;
        }
        int[] ans = new int[k];
        count = 0;
        i = 0;
        while(count<k)
        {
            ans[i] = pq.poll();
            i++;
            count++;
        }
        return ans;
    }
}