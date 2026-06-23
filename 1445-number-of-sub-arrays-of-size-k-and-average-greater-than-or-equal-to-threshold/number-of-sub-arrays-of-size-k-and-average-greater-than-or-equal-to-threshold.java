class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i;
        int left = 0;
        int right = k-1;
        int sum = 0;
        int count = 0;

        for(i=0;i<=right;i++)
        {
            sum += arr[i];
        }

        while(right<arr.length)
        {
            if(sum>=threshold*k)
            {
                count++;
            }
            if(right==arr.length-1)
            {
                break;
            }
            sum-=arr[left];
            left++;
            right++;
            sum+=arr[right];
        }

        return count;
    }
}