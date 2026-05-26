class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        HashSet<Character> hash = new HashSet<>();
        int i;
        char[] arr = word.toCharArray();
        for(i=0;i<word.length();i++)
        {
            if(!hash.contains(arr[i]))
            {
                hash.add(arr[i]);
            }
        }
        for(i=0;i<word.length();i++)
        {
            if('a'<=arr[i]&&arr[i]<='z'&&hash.contains((char)(arr[i]-32)))
            {
                count++;
                hash.remove((char)(arr[i]-32));
            }
        }
        return count;
    }
}