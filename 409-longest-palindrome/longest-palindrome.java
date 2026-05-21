class Solution {
    public int longestPalindrome(String s) {
        int length = 0;
        int odd = 1;
        HashMap<Character,Integer> hash = new HashMap<>();
        char[] str = s.toCharArray();
        int i;
        for(char c : str)
        {
            hash.put(c,hash.getOrDefault(c,0)+1);
        }
        for(char key : hash.keySet())
        {
            if(hash.get(key)%2==0)
            {
                length+=hash.get(key);
            }
            else if(hash.get(key)%2!=0)
            {
                length+=hash.get(key)-1;
                hash.put(key,1);
                if(odd==1)
                {
                    length+=1;
                    odd = 0;
                }
            }
        }
        return length;
    }
}