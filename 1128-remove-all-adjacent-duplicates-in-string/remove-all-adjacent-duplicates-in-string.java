class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int i;
        int remove = 0;
        for(i=0;i<arr.length;i++)
        {
            if(stack.isEmpty()||stack.peek()!=arr[i])
            {
                stack.push(arr[i]);
            }
            else
            {
                stack.pop();
                remove+=2;
            }
        }
        char[] ans = new char[arr.length-remove];
        int j = 0;
        while(!stack.isEmpty())
        {
            ans[j++] = stack.pop();
        }
        char temp;
        for(i=0;i<ans.length/2;i++)
        {
            temp = ans[i];
            ans[i] = ans[ans.length-i-1];
            ans[ans.length-i-1] = temp;
        }
        return new String(ans);
    }
}