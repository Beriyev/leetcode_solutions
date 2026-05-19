class Pair
{
    char c;
    int count;

    Pair(char c, int count)
    {
        this.c = c;
        this.count = count;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        char[] arr = s.toCharArray();
        int i;
        int remove=0;
        Stack<Pair> stack = new Stack<>();
        for(i=0;i<arr.length;i++)
        {
            if(stack.isEmpty()||stack.peek().c!=arr[i])
            {
                stack.push(new Pair(arr[i],1));
            }
            else
            {
                stack.push(new Pair(arr[i],stack.peek().count+1));
                if(stack.peek().count==k)
                {
                    for(int j=0;j<k;j++)
                    {
                        stack.pop();
                    }
                    remove+=k;
                }
            }
        }
        char[] ans = new char[arr.length-remove];
        int j = 0;
        while(!stack.isEmpty())
        {
            ans[j++] = stack.pop().c;
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