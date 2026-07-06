class StockSpanner {

    Stack<Pair> stack;

    public StockSpanner() {
        stack = new Stack();
    }
    
    public int next(int price) {
        int val = 1;
        if(stack.isEmpty())
        {
            stack.push(new Pair(price,0));
        }
        while(!stack.isEmpty()&&stack.peek().value<=price)
        {
            Pair popped = stack.pop();
            val += popped.span;
        }
        stack.push(new Pair(price,val));
        return val;
    }
}

class Pair {
    int value;
    int span;
    Pair(int value, int span)
    {
        this.value = value;
        this.span = span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */