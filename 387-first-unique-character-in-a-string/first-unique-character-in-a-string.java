class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> hash = new HashMap<>();
        char[] arr = s.toCharArray();
        int size = s.length();
        int i;
        for(i=0;i<size;i++)
        {
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
        }
        for(i=0;i<size;i++)
        {
            if(hash.get(arr[i])==1)
            {
                return i;
            }
        }
        return -1;
    }
}