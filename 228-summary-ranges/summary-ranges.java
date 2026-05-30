class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start, startidx, end, endidx;
        int i = 0;
        int j = 0;
        List<String> ans = new ArrayList<>();

        while(i<nums.length)
        {
            j = i;
            start = nums[i];
            startidx = i;
            end = nums[i];
            endidx = i;
            while(j<nums.length-1&&nums[j+1]==nums[j]+1)
            {
                j++;
                end = nums[j];
                endidx = j;
            }
            if(startidx==endidx)
            {
                ans.add(String.valueOf(nums[endidx]));
                i = endidx;
            }
            else
            {
                StringBuilder sb = new StringBuilder();
                sb.append(start);
                sb.append("->");
                sb.append(end);
                ans.add(sb.toString());
                i = endidx;
            }
            i++;
        }
        return ans;
    }
}