class Solution {
    public int smallestAbsent(int[] nums) {
        int i;
        double avg = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(i=0;i<nums.length;i++)
        {
            hash.put(nums[i],1);
            avg+=nums[i];
        }
        avg = avg/nums.length;
        double ansdbl = Math.ceil(avg);
        int ans = (int) ansdbl;
        if(avg%1==0)
        {
            ans++;
        }
        if(ans<=0)
        {
            ans = 1;
        }
        while(hash.containsKey(ans))
        {
            ans++;
        }
        return ans;
    }
}