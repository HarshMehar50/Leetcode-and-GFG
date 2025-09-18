class TaskManager {
    class Pair{
        int uid;
        int tid;
        int p;
        public Pair(int uid , int tid , int p){
            this.uid = uid;
            this.tid = tid;
            this.p = p;
        }
    }
    TreeSet<Pair> ts;
    TreeMap<Integer , Pair> map;
    public TaskManager(List<List<Integer>> tasks) {
        ts = new TreeSet<>((x , y)->(x.p != y.p)?Integer.compare(y.p , x.p):Integer.compare(y.tid , x.tid));
        map = new TreeMap<>();
        for(List<Integer> l : tasks){
            ts.add(new Pair(l.get(0) , l.get(1) , l.get(2)));
            map.put(l.get(1) , new Pair(l.get(0) , l.get(1) , l.get(2)));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        ts.add(new Pair(userId , taskId , priority));
        map.put(taskId , new Pair(userId , taskId , priority));
    }
    
    public void edit(int taskId, int newPriority) {
        Pair p1 = map.get(taskId);
        ts.remove(p1);
        ts.add(new Pair(p1.uid , taskId , newPriority));
        map.put(taskId , new Pair(p1.uid , taskId , newPriority));
    }
    
    public void rmv(int taskId) {
        Pair p1 = map.get(taskId);
        ts.remove(new Pair(p1.uid , taskId , p1.p));
        map.remove(taskId);
    }
    
    public int execTop() {
        if(ts.isEmpty() || map.isEmpty())
        return -1;
        int ans = ts.first().uid;
        Pair p1 = ts.pollFirst();
        map.remove(p1.tid);
        return ans;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */