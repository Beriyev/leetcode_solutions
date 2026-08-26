class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int right = 0;

        ArrayList<String> list = new ArrayList<>();

        int min = Integer.MAX_VALUE;

        int count = 0;

        String smallest = "";

        while(left<=right && right<s.length())
        {
            if(s.charAt(right)=='1')
            {
                count++;
            }

            while(count>k && left<=right)
            {
                if(s.charAt(left)=='1')
                {
                    count--;
                }
                left++;
            }
            
            while(count==k && s.charAt(left)=='0')
            {
                left++;
            }

            if(count==k)
            {
                if(right-left+1<min)
                {
                    min = right-left+1;
                    list.clear();
                    list.add(s.substring(left,right+1));
                }
                else if(right-left+1==min)
                {
                    list.add(s.substring(left,right+1));
                }
            }

            right++;
        }

        if(list.size()==0)
        {
            return "";
        }

        smallest = list.get(0);
        for(String str : list)
        {
            if(str.compareTo(smallest)<0)
            {
                smallest = str;
            }
        }

        return smallest;
    }
}