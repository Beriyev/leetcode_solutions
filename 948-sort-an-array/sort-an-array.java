class Solution {
    public int[] sortArray(int[] nums) {
        return sort(nums,0,nums.length);
    }

    int[] merge(int[] arr1, int[] arr2)
    {
        int i, j;
        i = 0;
        j = 0;

        int[] ans = new int[arr1.length+arr2.length];
        int k = 0;

        while(i<arr1.length&&j<arr2.length)
        {
            if(arr1[i]<arr2[j])
            {
                ans[k++] = arr1[i++];
            }
            else
            {
                ans[k++] = arr2[j++];
            }
        }

        if(i==arr1.length)
        {
            while(j<arr2.length)
            {
                ans[k++] = arr2[j++];
            }
        }
        else
        {
            while(i<arr1.length)
            {
                ans[k++] = arr1[i++];
            }
        }

        return ans;
    }

    int[] sort(int[] nums, int start, int end)
    {
        if(end-start==1)
        {
            return new int[]{nums[start]};
        }
        int mid = (start+end)/2;
        int[] left = sort(nums,start,mid);
        int[] right = sort(nums,mid,end);
        return merge(left,right);
    }
}