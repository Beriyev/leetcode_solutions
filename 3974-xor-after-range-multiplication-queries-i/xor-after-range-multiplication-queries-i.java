class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int idx;
        int ans = 0;
        int i;
        
        for(i=0;i<queries.length;i++)
        {
            idx = queries[i][0];
            while(idx<=queries[i][1])
            {
                nums[idx] = (int)(((long)nums[idx]*queries[i][3])%(1000000007));
                idx+=queries[i][2];
            }
        }

        for(int num : nums)
        {
            ans^=num;
        }

        return ans;
    }
}