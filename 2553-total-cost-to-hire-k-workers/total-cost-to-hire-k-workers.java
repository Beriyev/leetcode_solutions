class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Pair> front = new PriorityQueue<>((a,b)->a.val==b.val?a.idx-b.idx:a.val-b.val);
        PriorityQueue<Pair> back = new PriorityQueue<>((a,b)->a.val==b.val?a.idx-b.idx:a.val-b.val);
        int left = 0;
        int right = costs.length-1;
        int i;
        long ans = 0;
        int counter = 0;
        
        for(i=0;i<candidates&&left<=right;i++)
        {
            front.offer(new Pair(left,costs[left]));
            left++;
        }
        for(i=0;i<candidates&&left<=right;i++)
        {
            back.offer(new Pair(right,costs[right]));
            right--;
        }

        while(counter<k)
        {
            if(back.isEmpty()||(!front.isEmpty()&&front.peek().val<=back.peek().val))
            {
                ans+=front.poll().val;
                if(left<=right)
                {
                    front.offer(new Pair(left,costs[left]));
                    left++;
                }
            }
            else
            {
                ans+=back.poll().val;
                if(left<=right)
                {
                    back.offer(new Pair(right,costs[right]));
                    right--;
                }
            }
            counter++;
        }

        return ans;
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