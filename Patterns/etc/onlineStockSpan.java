class StockSpanner {

    // stack will store [price, span] as array value
    Stack<int[]> st;
    
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        // keep popping and updating span if price >= peek price
        while (!st.isEmpty() && price >= st.peek()[0]) {
            span += st.peek()[1];
            st.pop();
        }
        // else insert into stack
        st.add(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
