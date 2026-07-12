class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int i;
        int[] copy = Arrays.copyOf(arr,arr.length);
        Arrays.sort(copy);
        int counter = 1;
        for(i=0;i<arr.length;i++)
        {
            if(!hash.containsKey(copy[i]))
            {
                hash.put(copy[i],counter++);
            }
        }
        for(i=0;i<arr.length;i++)
        {
            arr[i] = hash.get(arr[i]);
        }
        return arr;
    }
}