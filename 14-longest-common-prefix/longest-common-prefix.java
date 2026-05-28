class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder output = new StringBuilder();
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
                    return output.toString();
                }
            }
            output = output.append(c);
        }
        return output.toString();
    }
}