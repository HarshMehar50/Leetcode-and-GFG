class Solution {
    class Pair{
        long s;
        int l;
        int r;
        public Pair(long s , int l , int r){
            this.s = s;
            this.l = l;
            this.r = r;
        }
    }
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        long[] ps = new long[nums.length];
        ps[0] = nums[0];
        for(int i = 1; i < ps.length; i++){
            ps[i] = ps[i-1]+(long)nums[i];
        }
        TreeMap<Integer , Integer> map = new TreeMap<>();
        //TreeSet<Pair> ts = new TreeSet<>((x , y)->Long.compare(y.s , x.s));
        TreeSet<Pair> ts = new TreeSet<>((a, b) -> {
        if (a.s != b.s) return Long.compare(b.s, a.s);
        if (a.l != b.l) return Integer.compare(a.l, b.l);
        return Integer.compare(a.r, b.r);
    });
        map.put(0 , ps.length-1);
        ts.add(new Pair(ps[ps.length-1] , 0 , ps.length-1));
        long[] ans = new long[removeQueries.length];
        for(int i = 0; i < ans.length; i++){
            int start = map.floorKey(removeQueries[i]);
            int end = map.get(start);
            map.remove(start);
            long sum = ps[end];
            if(start != 0)
            sum -= ps[start-1];
            ts.remove(new Pair(sum , start , end));
            if(removeQueries[i] != start){
                long ls = ps[removeQueries[i]-1];
                if(start != 0)
                ls -= ps[start-1];
                ts.add(new Pair(ls , start , removeQueries[i]-1));
                map.put(start , removeQueries[i]-1);
            }
            if(removeQueries[i] != end){
                long rs = ps[end]-ps[removeQueries[i]];
                ts.add(new Pair(rs , removeQueries[i]+1 , end));
                map.put(removeQueries[i]+1 , end);
            }
            if(!ts.isEmpty())
            ans[i] = ts.first().s;
        }
        return ans;
    }
    /*PriorityQueue<long[]> pq = new PriorityQueue<long[]>((x , y)->Long.compare(y[0] , x[0]));
        pq.offer(new long[]{ps[ps.length-1] , 0 , ps.length-1});
        long[] ans = new long[removeQueries.length];
        for(int i = 0; i < ans.length; i++){
            List<long[]> temp = new ArrayList<>();
            while(!(removeQueries[i] >= pq.peek()[1] && removeQueries[i] <= pq.peek()[2])){
                temp.add(pq.poll());
            }
            long[] a = pq.poll();
            if(removeQueries[i] != a[1]){
                long ls = ps[removeQueries[i]-1];
                if(a[1] != 0)
                ls -= ps[(int)a[1]-1];
                pq.offer(new long[]{ls , a[1] , removeQueries[i]-1});
            }
            if(removeQueries[i] != a[2]){
                long rs = ps[(int)a[2]]-ps[removeQueries[i]];
                pq.offer(new long[]{rs , removeQueries[i]+1 , a[2]});
            }
            for(long[] x : temp){
                pq.offer(x);
            }
            if(!pq.isEmpty())
            ans[i] = pq.peek()[0];
        }
        return ans;*/
}