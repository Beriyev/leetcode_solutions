class Solution {
    public String greatestLetter(String s) {
        HashSet<Character> hash = new HashSet<>();
        char max = 0;
        char curr = 0;
        String ans = "";

        int i;

        for(char c : s.toCharArray())
        {
            if(!hash.contains(c))
            {
                hash.add(c);
            }
        }

        for(char c : s.toCharArray())
        {
            if('a'<=c&&c<='z')
            {
                if(hash.contains((char)(c-32)))
                {
                    curr = c;
                }
            }
            else if('A'<=c&&c<='Z')
            {
                if(hash.contains((char)(c+32)))
                {
                    curr = c;
                }
            }
            if(curr>max)
            {
                max = (char)curr;
            }
        }
        if(Character.isLowerCase(max))
        {
            max = Character.toUpperCase(max);
        }
        if(max>0)
        {
            ans = String.valueOf(max);
        }
        return ans;
    }
}