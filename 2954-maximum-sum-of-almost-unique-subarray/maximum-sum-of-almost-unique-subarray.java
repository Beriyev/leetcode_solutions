class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        int left,right;
        int i, j;
        long sum = 0;
        long max = 0;
        left = 0;
        right = k-1;
        HashMap<Integer,Integer> hash = new HashMap<>();

        for(i=0;i<=right;i++)
        {
            sum+= nums.get(i);
            hash.put(nums.get(i),hash.getOrDefault(nums.get(i),0)+1);
        }

        if(hash.size()>=m)
        {
            max = sum;
        }

        for(right=k;right<nums.size();right++)
        {
            sum+=nums.get(right);
            hash.put(nums.get(right),hash.getOrDefault(nums.get(right),0)+1);

            if(right-left+1>k)
            {
                sum-=nums.get(left);
                hash.put(nums.get(left),hash.get(nums.get(left))-1);
                if(hash.get(nums.get(left))==0)
                {
                    hash.remove(nums.get(left));
                }
                left++;
            }

            if(hash.size()>=m)
            {
                max=Math.max(max,sum);
            }
        }

        return max;
    }
}