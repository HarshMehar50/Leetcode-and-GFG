class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] f = new int[k];
        TreeSet<Integer> pqs = new TreeSet<>();
        PriorityQueue<long[]> pqr = new PriorityQueue<long[]>((x , y)->Long.compare(x[1] , y[1]));
        for(int i = 0; i < k; i++){
            pqs.add(i);
        }
        for(int i = 0; i < arrival.length; i++){
            while(!pqr.isEmpty() && arrival[i] >= pqr.peek()[1]){
                long[] e = pqr.peek();
                pqr.poll();
                pqs.add((int)e[2]); 
            }
            if(!pqs.isEmpty()){
                int s = -1;
                if(pqs.ceiling(i%k) != null){
                s = pqs.ceiling(i%k);
                pqs.remove(s);
                }else
                s = pqs.pollFirst();
                f[s]++;
                pqr.offer(new long[]{arrival[i] , arrival[i]+load[i] , s});
            }
        }
        int max = 0;
        for(int i = 0; i < k; i++){
            max = Math.max(max , f[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i++){
            if(f[i] == max)
            ans.add(i);
        }
        return ans;
    }
}