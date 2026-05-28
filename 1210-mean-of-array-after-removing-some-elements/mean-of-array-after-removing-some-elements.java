class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int idxs = arr.length/20;
        double mean = 0;
        int i;
        for(i=idxs;i<=arr.length-idxs-1;i++)
        {
            mean+=arr[i];
        } 
        return mean/(arr.length-2*idxs);
    }
}