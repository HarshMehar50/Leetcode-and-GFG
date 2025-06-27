class Solution {
    boolean[] seive(int n){
        boolean[] p = new boolean[n+1];
        Arrays.fill(p , true);
        for(int i = 2; i <= n; i++){
            if(p[i] && (long)((long)i*(long)i) <= n){
                for(int j = i*i; j <= n; j += i){
                    p[j] = false;
                }
            }
        }
        p[1] = false;
        return p;
    }
    public int primeSubarray(int[] nums, int k) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(nums[i] , max);
        }
        boolean[] prime = seive(max);
        /*List<int[]> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(prime[nums[i]])
                list.add(new int[]{nums[i] , i});
        }*/
        /*int l = 0;
        PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        PriorityQueue<int[]> pq2 = new PriorityQueue<int[]>((x , y)->Integer.compare(y[0] , x[0]));
        int ans = 0;
        for(int r = 0; r < l1.size(); r++){
            pq1.add(l1.get(r));
            pq2.add(l1.get(r));
            while((!pq1.isEmpty() || !pq2.isEmpty()) && pq2.peek()[0]-pq1.peek()[0] > k){
                if(pq1.peek()[1] <= pq2.peek()[1]){
                    pq1.poll();
                    l++;
                }else{
                    pq2.poll();
                    l++;
                }
            }
            if(!pq1.isEmpty() && !pq2.isEmpty() && pq2.peek()[0]-pq1.peek()[0] <= k)
                ans += r-l+1;
        }*/
        /*int ans = 0;
        TreeMap<Integer , Integer> f = new TreeMap<>();
        int l = 0;
        Deque<int[]> dq = new LinkedList<>();
        for(int r = 0; r < list.size(); r++){
            f.put(list.get(r)[0] , f.getOrDefault(list.get(r)[0] , 0)+1);
            dq.add(list.get(r));
            while(f.size() > 0 && f.lastKey()-f.firstKey() > k){
                f.put(list.get(l)[0] , f.get(list.get(l)[0])-1);
                if(f.get(list.get(l)[0]) == 0)
                f.remove(list.get(l)[0]);
                dq.poll();
                l++;
            }
            if(dq.size() >= 2){
                int[] fp = dq.pollLast();
                int lp = dq.peekLast()[1];
                ans += lp-l+1;
                dq.add(fp);
            }
        }
        return ans;*/
        int l = 0;
        int ans = 0;
        TreeMap<Integer , Integer> f = new TreeMap<>();
        Deque<int[]> dq = new LinkedList<>();
        for(int r = 0; r < nums.length; r++){
            if(prime[nums[r]]){
                f.put(nums[r] , f.getOrDefault(nums[r] , 0)+1);
                dq.add(new int[]{nums[r] , r});
            }
            while(f.size() > 0 && f.lastKey()-f.firstKey() > k){
                if(prime[nums[l]]){
                    f.put(nums[l] , f.get(nums[l])-1);
                    if(f.get(nums[l]) == 0)
                    f.remove(nums[l]);
                    dq.poll();
                }
                l++;
            }
            if(dq.size() >= 2){
                int[] fp = dq.pollLast();
                int sp = dq.peekLast()[1];
                ans += sp-l+1;
                dq.add(fp);
            }
        }
        return ans;
    }
}