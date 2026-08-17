class Solution {
    boolean check(HashMap<Character,Integer> sHash,HashMap<Character,Integer> tHash)
    {
        for(char c : tHash.keySet())
        {
            if(sHash.getOrDefault(c,0)<tHash.get(c))
            {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        HashMap<Character,Integer> sHash = new HashMap<>();
        HashMap<Character,Integer> tHash = new HashMap<>();
        int left = 0;
        int right = 0;

        for(char c : t.toCharArray())
        {
            tHash.put(c,tHash.getOrDefault(c,0)+1);
        }

        String ans = "";

        while(left<=right && right<s.length())
        {
            sHash.put(s.charAt(right),sHash.getOrDefault(s.charAt(right),0)+1);
            while(check(sHash,tHash))
            {
                if(ans.equals("") || ans.length()>right-left+1)
                {
                    ans = s.substring(left,right+1);
                }
                sHash.put(s.charAt(left),sHash.get(s.charAt(left))-1);
                if(sHash.get(s.charAt(left))==0)
                {
                    sHash.remove(s.charAt(left));
                }
                left++;
            }
            right++;
        }

        return ans;
    }
}