class Router {
    HashMap<Integer , List<Integer>> map;
    HashSet<String> set;
    int n;
    Queue<int[]> q;
    public Router(int memoryLimit) {
        n = memoryLimit;
        q = new LinkedList<>();
        set = new HashSet<>();
        map = new HashMap<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        String s = source+" "+destination+" "+timestamp;
        if(set.contains(s))
        return false;
        if(q.size() == n){
            int[] a = q.poll();
            set.remove(a[0]+" "+a[1]+" "+a[2]);
            map.get(a[1]).remove(0);
            if(map.get(a[1]).isEmpty())
            map.remove(a[1]);
        }
        q.offer(new int[]{source , destination , timestamp});
        set.add(s);
        if(!map.containsKey(destination))
        map.put(destination , new ArrayList<>());
        map.get(destination).add(timestamp);
        return true;
    }
    
    public int[] forwardPacket() {
        if(q.isEmpty())
        return new int[]{};
        int[] a = q.poll();
        set.remove(a[0]+" "+a[1]+" "+a[2]);
        map.get(a[1]).remove(0);
        if(map.get(a[1]).isEmpty())
        map.remove(a[1]);
        return a;
    }
    int floor(List<Integer> l , int x){
        int s = 0;
        int e = l.size()-1;
        int f = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(l.get(m) <= x){
                f = m;
                s = m+1;
            }else
            e = m-1;
        }
        return f;
    }
    public int getCount(int destination, int startTime, int endTime) {
        if(!map.containsKey(destination))
        return 0;
        return floor(map.get(destination) , endTime)-floor(map.get(destination) , startTime-1);
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */