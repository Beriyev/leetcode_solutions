class Solution {
    public char findTheDifference(String s, String t) {
        char[] str;
        char[] ser;
        if(s.length()<t.length())
        {
            str = s.toCharArray();
            ser = t.toCharArray();
        }
        else 
        {
            str = t.toCharArray();
            ser = s.toCharArray();
        }
        HashMap<Character,Integer> hash = new HashMap<>();
        for(char c : str)
        {
            hash.put(c,hash.getOrDefault(c,0)+1);
        }
        for(char c : ser)
        {
            if(!hash.containsKey(c))
            {
                return c;
            }
            else if(hash.get(c)>0)
            {
                hash.put(c,hash.get(c)-1);
            }
            else if(hash.get(c)==0)
            {
                return c;
            }
        }
        return 'a';
    }
}