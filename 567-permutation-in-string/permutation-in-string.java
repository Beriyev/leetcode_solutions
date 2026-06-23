class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int i;
        int left,right;
        left = 0;
        right = s1.length()-1;

        int[] freq = new int[26];

        if(s2.length()<s1.length())
        {
            return false;
        }

        for(i=0;i<=right;i++)
        {
            freq[s2.charAt(i)-'a']++;
        }

        int[] ans = new int[26];

        for(char c : s1.toCharArray())
        {
            ans[c-'a']++;
        }

        while(right<s2.length())
        {
            for(i=0;i<freq.length;i++)
            {
                if(freq[i]!=ans[i])
                {
                    break;
                }
            }
            if(i==freq.length)
            {
                return true;
            }
            if(right==s2.length()-1)
            {
                break;
            }
            freq[s2.charAt(left)-'a']--;
            left++;
            right++;
            freq[s2.charAt(right)-'a']++;
        }
        return false;
    }
}