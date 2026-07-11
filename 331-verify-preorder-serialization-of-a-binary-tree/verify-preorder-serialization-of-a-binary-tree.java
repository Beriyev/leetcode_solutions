class Solution {
    int idx = 0;

    public boolean isValidSerialization(String preorder) {
        String[] strings = preorder.split(",");
        Stack<String> stack = new Stack<>();
        stack.push(strings[0]);
        int i;
        for(i=1;i<strings.length;i++)
        {
            stack.push(strings[i]);
            while(stack.size()>=3&&stack.get(stack.size()-1).equals("#")&&stack.get(stack.size()-2).equals("#")&&!stack.get(stack.size()-3).equals("#"))
            {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }
        }
        if(stack.size()==1&&stack.peek().equals("#"))
        {
            return true;
        }
        return false;
    }
}