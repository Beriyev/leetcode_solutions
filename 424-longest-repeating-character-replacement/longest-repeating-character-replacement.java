class Solution {
    public int characterReplacement(String s, int k) {
        int i;
        int left, right;
        left = 0;
        right = 0;
        int frequent = 0;
        char mostfrequent;
        int[] freq = new int[26];
        int longest = 0;

        for(right=0;right<s.length();right++)
        {
            frequent = 0;
            freq[s.charAt(right)-'A']++;
            for(i=0;i<26;i++)
            {
                frequent = Math.max(frequent,freq[i]);
            }
            while((right-left+1)-frequent > k)
            {
                freq[s.charAt(left)-'A']--;
                left++;
            }
            longest = Math.max(longest,right-left+1);
        }

        return longest;
    }
}