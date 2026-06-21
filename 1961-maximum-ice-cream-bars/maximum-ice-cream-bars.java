class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;
        int i,j;
        int counter;

        j=0;

        for(int cost : costs)
        {
            if(cost>max)
            {
                max = cost;
            }
        }

        int[] freq = new int[max+1];

        Arrays.fill(freq,0);

        for(int cost : costs)
        {
            freq[cost]++;
        }

        for(i=0;i<freq.length;i++)
        {
            if(freq[i]==0)
            {
                continue;
            }
            counter = freq[i];
            while(counter>0)
            {
                costs[j++] = i;
                counter--;
            }
        }

        int sum = 0;
        for(i=0;i<costs.length;i++)
        {
            if(coins-costs[i]>=0)
            {
                sum++;
                coins-=costs[i];
            }
            else
            {
                break;
            }
        }
        return sum;
    }
}