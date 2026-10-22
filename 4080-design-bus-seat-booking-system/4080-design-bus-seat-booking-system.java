class BusBooking {
    HashMap<String , Integer> map;
    int total;
    public BusBooking(int n) {
        map = new HashMap<>();
        total = 0;
    }
    
    public void toggle(String seat) {
        if(map.containsKey(seat)){
            total -= map.get(seat);
            map.remove(seat);
            return;
        }
        StringBuilder sb = new StringBuilder();
        if(seat.charAt(0) == 'A')
        sb.append("B");
        else if(seat.charAt(0) == 'D')
        sb.append("C");
        else
        sb.append("");
        sb.append(seat.substring(1));
        String s = sb.toString();
        if(map.containsKey(s))
        map.put(seat , 3);
        else
        map.put(seat , 1);
        total += map.get(seat);
    }
    
    public int getTotalTime() {
        return total;
    }
    
    public int getMinTime() {
        return map.size();
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */