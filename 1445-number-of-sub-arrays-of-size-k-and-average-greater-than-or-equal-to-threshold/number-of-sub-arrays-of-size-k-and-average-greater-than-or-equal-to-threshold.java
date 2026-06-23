class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i;
        int left = 0;
        int right = k-1;
        double avg = 0;
        int count = 0;

        for(i=0;i<=right;i++)
        {
            avg+= (double)arr[i]/k;
        }

        while(right<arr.length)
        {
            if(avg>=threshold)
            {
                count++;
            }
            if(right==arr.length-1)
            {
                break;
            }
            avg-= (double)arr[left]/k;
            left++;
            right++;
            avg+= (double)arr[right]/k;
        }

        return count;
    }
}