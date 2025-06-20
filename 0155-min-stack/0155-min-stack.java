class MinStack {
    Stack<Integer> s;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        min = Math.min(min , val);
    }
    
    public void pop() {
        int t = s.peek();
        s.pop();
        if(min == t){
            min = Integer.MAX_VALUE;
            Stack<Integer> s1 = new Stack<>();
            while(!s.isEmpty()){
                int e = s.pop();
                min = Math.min(min , e);
                s1.push(e);
            }
            while(!s1.isEmpty()){
                int e = s1.pop();
                s.push(e);
            }
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */