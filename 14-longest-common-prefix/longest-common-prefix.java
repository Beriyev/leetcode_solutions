class Solution {
    public String longestCommonPrefix(String[] strs) {
        String output = "";
        int min = Integer.MAX_VALUE;

        for(String str : strs)
        {
            if(str.length()<min)
            {
                min = str.length();
            }
        }

        int i;
        char c;

        for(i=0;i<min;i++)
        {
            c = strs[0].charAt(i);
            for(String str : strs)
            {
                if(str.charAt(i)!=c)
                {
                    return output;
                }
            }
            output = output+String.valueOf(c);
        }
        return output;
    }
}