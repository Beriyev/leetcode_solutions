class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.val == a.val ? b.idx - a.idx : b.val - a.val);
        int left = 0;
        int right = k-1;
        int i;

        for(i=0;i<k;i++)
        {
            pq.offer(new Pair(i,nums[i]));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        
        while(right<nums.length)
        {
            while(pq.peek().idx<left)
            {
                pq.poll();
            }
            ans.add(pq.peek().val);
            left++;
            right++;
            if(right<nums.length)
            {
                pq.offer(new Pair(right,nums[right]));
            }
        }

        int[] ansArray = new int[ans.size()];

        for(i=0;i<ansArray.length;i++)
        {
            ansArray[i] = ans.get(i);
        }

        return ansArray;
    }
}

class Pair
{
    int idx;
    int val;
    
    Pair(int idx, int val)
    {
        this.idx = idx;
        this.val = val;
    }
}