class Solution {
    public int findTheWinner(int n, int k) {
        int elim = n-1;
        int counter = 0;
        int[] arr = new int[n];
        Arrays.fill(arr,1);
        int i = 0;
        while(elim!=0)
        {   
            counter = 0;
            while(counter<k)
            {
                if(arr[i]==1)
                {
                    counter++;
                }
                if(counter==k)
                {
                    break;
                }
                i=(i+1)%n;
            }
            if(arr[i]==1)
            {
                arr[i] = 0;
            }
            elim--;
            while(arr[i]==0)
            {
                i=(i+1)%n;
            }
        }
        int remaining = 0;
        for(i=0;i<arr.length;i++)
        {
            if(arr[i]==1)
            {
                remaining = i+1;
                break;
            }
        }
        return remaining;
    }
}