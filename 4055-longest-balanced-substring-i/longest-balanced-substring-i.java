class Solution {
    public int longestBalanced(String s) {
        int i, j;
        int max = 0;
        int f;
        int k;
        for(i=0;i<s.length();i++)
        {
            int[] freq = new int[26];
            Arrays.fill(freq,0);
            for(j=i;j<s.length();j++)
            {
                freq[s.charAt(j)-'a']++;
                f = freq[s.charAt(j)-'a'];
                for(k=0;k<26;k++)
                {
                    if(freq[k]!=f)
                    {
                        if(freq[k]!=0)
                        {
                            break;
                        }
                    }
                }
                if(k==26)
                {
                    if(j-i+1>max)
                    {
                        max = j-i+1;
                    }
                }
            }
        }
        return max;
    }
}