class Solution {
    long dijkstra(HashMap<Integer , List<int[]>> adj , int src , int des){
        PriorityQueue<long[]> pq = new PriorityQueue<long[]>((x , y)->Long.compare(x[0] , y[0]));
        long[] d = new long[26];
        Arrays.fill(d , (long)(1e16));
        pq.offer(new long[]{0 , src});
        d[src] = 0;
        while(!pq.isEmpty()){
            long node = pq.peek()[1];
            long distance = pq.peek()[0];
            pq.poll();
            if(node == des)
            return distance;
            for(int[] a : adj.get((int)node)){
                if(distance+a[1] < d[a[0]]){
                    d[a[0]] = distance+a[1];
                    pq.offer(new long[]{d[a[0]] , a[0]});
                }
            } 
        }
        return -1;
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < 26; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < original.length; i++){
            adj.get((int)(original[i]-'a')).add(new int[]{(int)(changed[i]-'a') , cost[i]});
        }
        /*long ans = 0;
        for(int i = 0; i < source.length(); i++){
            if(source.charAt(i) != target.charAt(i)){
            long d = dijkstra(adj , (int)(source.charAt(i)-'a') , (int)(target.charAt(i)-'a'));
            if(d == -1)
            return -1;
            ans += d;
            }
        }
        return ans;*/
        long[][] d = new long[26][26];
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                if(i != j)
                d[i][j] = dijkstra(adj , i , j);
            }
        }
        long ans = 0;
        for(int i = 0; i < source.length(); i++){
            if(source.charAt(i) != target.charAt(i)){
                if(d[source.charAt(i)-'a'][target.charAt(i)-'a'] == -1)
                return -1;
                ans += d[source.charAt(i)-'a'][target.charAt(i)-'a'];
            }
        }
        return ans;
    }
}