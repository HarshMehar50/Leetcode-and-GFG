class SmallestInfiniteSet {
    TreeSet<Integer> deleted;
    int min = 1;
    public SmallestInfiniteSet() {
        deleted = new TreeSet<>();
    }
    
    public int popSmallest() {
        if(!deleted.isEmpty())
        return deleted.pollFirst();
        return min++;
    }
    
    public void addBack(int num) {
        if(num < min)
        deleted.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */