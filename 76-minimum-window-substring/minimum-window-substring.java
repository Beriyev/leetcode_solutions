class Solution {

    public String minWindow(String s, String t) {
        HashMap<Character,Integer> sHash = new HashMap<>();
        HashMap<Character,Integer> tHash = new HashMap<>();
        int left = 0;
        int right = 0;

        int counter = 0;

        for(char c : t.toCharArray())
        {
            tHash.put(c,tHash.getOrDefault(c,0)+1);
        }

        String ans = "";

        while(left<=right && right<s.length())
        {
            sHash.put(s.charAt(right),sHash.getOrDefault(s.charAt(right),0)+1);
            if(tHash.containsKey(s.charAt(right)) && sHash.get(s.charAt(right)).equals(tHash.get(s.charAt(right))))
            {
                counter++;
            }
            while(counter == tHash.size())
            {
                if(ans.equals("") || ans.length()>right-left+1)
                {
                    ans = s.substring(left,right+1);
                }
                if(tHash.containsKey(s.charAt(left)) && sHash.get(s.charAt(left)).equals(tHash.get(s.charAt(left))))
                {
                    counter--;
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