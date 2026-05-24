class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int max1, max2;
        max1 = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        max2 = nums[0]*nums[1]*nums[nums.length-1];
        return max1>max2?max1:max2;
    }
}