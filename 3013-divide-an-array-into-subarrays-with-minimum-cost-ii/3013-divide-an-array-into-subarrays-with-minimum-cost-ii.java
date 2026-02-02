class Solution {
    class Pair{
        int n;
        int idx;
        public Pair(int n , int idx){
            this.n = n;
            this.idx = idx;
        }
    }
    public long minimumCost(int[] nums, int k, int dist) {
        long ans = (long)(1e17);
        TreeSet<Pair> ts1 = new TreeSet<>((x , y)->(x.n != y.n)?Integer.compare(x.n , y.n):Integer.compare(x.idx , y.idx));
        TreeSet<Pair> ts2 = new TreeSet<>((x , y)->(x.n != y.n)?Integer.compare(x.n , y.n):Integer.compare(x.idx , y.idx));
        long ws = 0;
        for(int i = 1; i <= Math.min(dist+1 , nums.length-1); i++){
            ts1.add(new Pair(nums[i] , i));
            ws += nums[i];
        }
        while(ts1.size() > k-1){
            Pair p = ts1.pollLast();
            ws -= p.n;
            ts2.add(p);
        }
        ans = Math.min(ans , ws);
        for(int i = 1; i+dist+1 < nums.length; i++){
            ts2.add(new Pair(nums[i+dist+1] , i+dist+1));
            Pair p = new Pair(nums[i] , i);
            if(ts1.contains(p)){
                ts1.remove(p);
                ws -= nums[i];
                Pair p2 = ts2.pollFirst();
                ts1.add(p2);
                ws += p2.n;
            }else{
                ts2.remove(p);
                Pair p2 = ts2.first();
                Pair p1 = ts1.last();
                if(p2.n < p1.n){
                    ts1.remove(p1);
                    ts2.add(p1);
                    ws -= p1.n;
                    ts2.remove(p2);
                    ts1.add(p2);
                    ws += p2.n;
                } 
            }
            ans = Math.min(ans , ws);
        }
        return ans+nums[0];
    }
}