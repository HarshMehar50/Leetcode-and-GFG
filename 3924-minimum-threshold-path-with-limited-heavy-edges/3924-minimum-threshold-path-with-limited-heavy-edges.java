class Solution {
    boolean predicate(int n , int[][] edges , int source , int target , int k , int m){
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int[] e : edges){
            int w = 0;
            if(e[2] > m)
            w = 1;
            adj.get(e[0]).add(new int[]{e[1] , w});
            adj.get(e[1]).add(new int[]{e[0] , w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int[] d = new int[n];
        Arrays.fill(d , Integer.MAX_VALUE);
        d[source] = 0;
        pq.offer(new int[]{d[source] , source});
        while(!pq.isEmpty()){
            int node = pq.peek()[1];
            int distance = pq.peek()[0];
            pq.poll();
            for(int[] a : adj.get(node)){
                if(a[1]+distance < d[a[0]]){
                    d[a[0]] = distance+a[1];
                    pq.offer(new int[]{d[a[0]] , a[0]});
                }
            }
        }
        return (d[target] <= k);
    }
    public int minimumThreshold(int n, int[][] edges, int source, int target, int k) {
        int s = 0;
        int e = 0;
        for(int[] x : edges){
            e = Math.max(e , x[2]);
        }
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(predicate(n , edges , source , target , k , m)){
                ans = m;
                e = m-1;
            }else
            s = m+1;
        }
        return ans;
    }
}