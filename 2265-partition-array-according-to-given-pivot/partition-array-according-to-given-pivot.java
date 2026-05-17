class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int temp;
        ArrayList<Integer> lesser = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();
        int i;
        int gtno = 0;
        int eno = 0;
        int lno = 0;
        int[] ans = new int[nums.length];
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]<pivot)
            {
                lesser.add(nums[i]);
                lno++;
            }
            else if(nums[i]==pivot)
            {
                equal.add(nums[i]);
                eno++;
            }
            else
            {
                greater.add(nums[i]);
                gtno++;
            }
        }
        int j = 0;
        for(i=0;i<lno;i++)
        {
            ans[j] = lesser.get(i);
            j++;
        }
        for(i=0;i<eno;i++)
        {
            ans[j] = equal.get(i);
            j++;
        }
        for(i=0;i<gtno;i++)
        {
            ans[j] = greater.get(i);
            j++;
        }
        return ans;
    }
}