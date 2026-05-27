class Solution {
    public String toLowerCase(String s) {
        char[] arr = s.toCharArray();
        int i;
        for(i=0;i<s.length();i++)
        {
            if(Character.isUpperCase(arr[i]))
            {
                arr[i] = Character.toLowerCase(arr[i]);
            }
        }
        return new String(arr);
    }
}