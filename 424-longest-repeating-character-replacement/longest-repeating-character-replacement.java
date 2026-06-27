class Solution {
    public int characterReplacement(String s, int k) {
        int left, right;
        left = 0;
        int frequent = 0;
        int[] freq = new int[26];
        int i;
        int max = 0;

        for(right=0;right<s.length();right++)
        {
            freq[s.charAt(right)-'A']++;
            frequent = 0;

            for(i=0;i<26;i++)
            {
                frequent = Math.max(frequent,freq[i]);
            }

            while((right-left+1)-frequent>k)
            {
                freq[s.charAt(left)-'A']--;
                left++;
            }

            if(right-left+1 > max)
            {
                max = right-left+1;
            }
        }
        return max;
    }
}