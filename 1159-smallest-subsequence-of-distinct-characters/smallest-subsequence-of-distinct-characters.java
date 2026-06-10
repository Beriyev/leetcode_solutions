class Solution {
    public String smallestSubsequence(String s) {
        char[] arr = s.toCharArray();
        int i;
        Stack<Character> stack = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        HashMap<Character,Integer> hash = new HashMap<>();

        for(i=0;i<arr.length;i++)
        {
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
        }

        for(i=0;i<arr.length;i++)
        {
            hash.put(arr[i],hash.get(arr[i])-1);
            if(set.contains(arr[i]))
            {
                continue;
            }
            else
            {
                while(!stack.isEmpty()&&hash.get(stack.peek())>0&&arr[i]<stack.peek())
                {
                    set.remove(stack.peek());
                    stack.pop();
                }
                set.add(arr[i]);
                stack.push(arr[i]);
            }
        }

        char[] ans = new char[stack.size()];
        i=0;
        while(!stack.isEmpty())
        {
            ans[i++] = stack.pop();
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