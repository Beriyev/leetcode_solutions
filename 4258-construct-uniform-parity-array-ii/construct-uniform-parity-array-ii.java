class Solution {
    public boolean uniformArray(int[] nums1) {
        int even = 1;
        int i;
        for(i=0;i<nums1.length;i++)
        {
            if(nums1[i]%2!=0)
            {
                even = 0;
                break;
            }
        }
        if(even == 1)
        {
            return true;
        }
        else
        {
            int min = Integer.MAX_VALUE;
            for(int num : nums1)
            {
                min = Math.min(min,num);
            }
            if(min%2==1)
            {
                return true;
            }
        }
        return false;
    }
}