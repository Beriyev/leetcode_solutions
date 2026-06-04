class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> hash = new HashSet<>();
        int count = 0;
        char[] jewelString = jewels.toCharArray();
        char[] stonesString = stones.toCharArray();
        for(char c : jewelString)
        {
            hash.add(c);
        }
        for(char c : stonesString)
        {
            if(hash.contains(c))
            {
                count++;
            }
        }
        return count;
    }
}