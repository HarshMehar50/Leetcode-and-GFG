class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        /*double[] ans = new double[nums.length-k+1];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>((x , y)->Integer.compare(x[1] , y[1]));
        for(int i = 0; i < k; i++){
            pq.offer(new int[]{nums[i] , i});
        }
        if(k%2 != 0){
            for(int i = 0; i < k/2; i++){
                int a[] = pq.poll();
                pq1.offer(a);
            }
            ans[0] = pq.peek()[0];
        }else{
            for(int i = 0; i < k/2-1; i++){
                int a[] = pq.poll();
                pq1.offer(a);
            }
            ans[0] += pq.peek()[0];
            int[] b = pq.poll();
            pq1.offer(b);
            ans[0] += pq.peek()[0];
            ans[0] = ans[0]/2;
        }
        while(!pq.isEmpty()){
            pq1.offer(pq.poll());
        }
        pq1.poll();
        while(!pq1.isEmpty()){
            pq.offer(pq1.poll());
        }
        for(int i = 1; i < ans.length; i++){
            pq.offer(new int[]{nums[k+i-1] , k+i-1});
            if(k%2 != 0){
            for(int j = 0; j < k/2; j++){
                int a[] = pq.poll();
                pq1.offer(a);
            }
            ans[i] = pq.peek()[0];
        }else{
            for(int j = 0; j < k/2-1; j++){
                int a[] = pq.poll();
                pq1.offer(a);
            }
            ans[i] += pq.peek()[0];
            int[] b = pq.poll();
            pq1.offer(b);
            ans[i] += pq.peek()[0];
            ans[i] = ans[0]/2;
        }
        while(!pq.isEmpty()){
            pq1.offer(pq.poll());
        }
        pq1.poll();
        while(!pq1.isEmpty()){
            pq.offer(pq1.poll());
        }
        }
        return ans;*/
        List<Double> ans = new ArrayList<>();
        TreeSet<int[]> ts1 = new TreeSet<>((x , y)->(x[0] != y[0])?Integer.compare(y[0] , x[0]):Integer.compare(y[1] , x[1]));
        TreeSet<int[]> ts2 = new TreeSet<>((x , y)->(x[0] != y[0])?Integer.compare(x[0] , y[0]):Integer.compare(x[1] , y[1]));
        for(int i = 0; i < nums.length; i++){
            if(ts1.isEmpty() || nums[i] <= ts1.first()[0])
                ts1.add(new int[]{nums[i] , i});
            else
                ts2.add(new int[]{nums[i] , i});
            if(i >= k){
                int[] r = new int[]{nums[i-k] , i-k};
                if(ts1.contains(r))
                    ts1.remove(r);
                else
                    ts2.remove(r);
            }
            while(ts1.size() > ts2.size()+1){
                ts2.add(ts1.pollFirst());
            }
            while(ts2.size() > ts1.size()){
                ts1.add(ts2.pollFirst());
            }
            if(i >= k-1){
                if(k%2 == 1)
                    ans.add((double)ts1.first()[0]);
                else
                    ans.add((double)((double)ts1.first()[0]+(double)ts2.first()[0])/2);
            }
        }
        double[] fans = new double[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            fans[i] = ans.get(i);
        }
        return fans;
    }
}