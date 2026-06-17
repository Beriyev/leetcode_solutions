class Solution {
    public int findMiddleIndex(int[] nums) {
        int middle = 0;
        int left = 0;
        int right = 0;
        int i;

        while(middle<nums.length)
        {
            left = 0;
            right = 0;
            for(i=0;i<middle;i++)
            {
                left+=nums[i];
            }
            for(i=middle+1;i<nums.length;i++)
            {
                right+=nums[i];
            }
            if(left==right)
            {
                return middle;
            }
            middle++;
        }
        return -1;
    }
}