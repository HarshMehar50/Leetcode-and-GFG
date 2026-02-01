class RideSharingSystem {
    PriorityQueue<int[]> pqd;
    PriorityQueue<int[]> pqr;
    int td;
    int tr;
    public RideSharingSystem() {
        pqd = new PriorityQueue<int[]>((x , y)->Integer.compare(x[1] , y[1]));
        pqr = new PriorityQueue<int[]>((x , y)->Integer.compare(x[1] , y[1]));
        td = 0;
        tr = 0;
    }
    
    public void addRider(int riderId) {
        pqr.offer(new int[]{riderId , tr});
        tr++;
    }
    
    public void addDriver(int driverId) {
        pqd.offer(new int[]{driverId , td});
        td++;
    }
    
    public int[] matchDriverWithRider() {
        if(pqr.isEmpty() || pqd.isEmpty())
        return new int[]{-1 , -1};
        return new int[]{pqd.poll()[0] , pqr.poll()[0]};
    }
    
    public void cancelRider(int riderId) {
        List<int[]> l = new ArrayList<>();
        while(!pqr.isEmpty() && pqr.peek()[0] != riderId){
            l.add(pqr.poll());
        }
        pqr.poll();
        for(int[] a : l){
            pqr.offer(a);
        }
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */