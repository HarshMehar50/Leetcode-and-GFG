class MyCalendar {
    List<int[]> l;
    public MyCalendar() {
        l = new ArrayList<>();
    }
    int ceil(int x){
        int s = 0;
        int e = l.size()-1;
        int c = l.size();
        while(s <= e){
            int m = s+(e-s)/2;
            if(l.get(m)[1] < x)
            s = m+1;
            else{
                c = m;
                e = m-1;
            }           
        }
        return c;
    }
    
    public boolean book(int startTime, int endTime) {
        int cc = ceil(startTime);
        if(cc > 0 && l.get(cc-1)[1] > startTime)
        return false;
        if(cc < l.size() && l.get(cc)[0] < endTime)
        return false;
        l.add(cc, new int[]{startTime , endTime-1});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */