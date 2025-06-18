class BrowserHistory {
    class Node{
        String s;
        Node next;
        Node back;
        public Node(String s){
            this.s = s;
        }
        public Node(String s , Node next , Node back){
            this.s = s;
            this.next = next;
            this.back = back;
        }
    }
    Node c;
    public BrowserHistory(String homepage) {
        c = new Node(homepage);
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        c.next = node;
        node.back = c;
        c = node; 
    }
    
    public String back(int steps) {
        while(steps > 0){
            if(c.back != null)
            c = c.back;
            else
            break;
            steps--;
        }
        return c.s;
    }
    
    public String forward(int steps) {
        while(steps > 0){
            if(c.next != null)
            c = c.next;
            else
            break;
            steps--;
        }
        return c.s;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */