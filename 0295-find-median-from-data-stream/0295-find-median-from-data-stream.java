class MedianFinder {
    PriorityQueue<Integer> maxpq;
    PriorityQueue<Integer> minpq;
    public MedianFinder() {
        maxpq = new PriorityQueue<>(Collections.reverseOrder());
        minpq = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxpq.isEmpty() || num < maxpq.peek())
            maxpq.offer(num);
        else
            minpq.offer(num);
        if(Math.abs(maxpq.size()-minpq.size()) > 1)
            minpq.offer(maxpq.poll());
        else if(maxpq.size() < minpq.size())
            maxpq.offer(minpq.poll());
    }

    public double findMedian() {
        if(minpq.size() == maxpq.size())
            return (minpq.peek()+maxpq.peek())/2.00;
        else
            return maxpq.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */