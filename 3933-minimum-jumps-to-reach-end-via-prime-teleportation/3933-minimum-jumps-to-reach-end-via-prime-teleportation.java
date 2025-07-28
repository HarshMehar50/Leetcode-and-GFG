class Solution {
    List<Integer> primeFactorization(int[] spf , int x){
        List<Integer> ans = new ArrayList<>();
        while(x != 1){
            int p = spf[x];
            while(x%p == 0){
                x = x/p;
            }
            ans.add(p);
        }
        return ans;
    }
    public int minJumps(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max , nums[i]);
        }
        boolean[] p = new boolean[max+1];
        int[] spf = new int[max+1];
        Arrays.fill(p , true);
        Arrays.fill(spf , Integer.MAX_VALUE);
        p[0] = false;
        p[1] = false;
        for(int i = 2; i <= max; i++){
            if(p[i]){
                spf[i] = i;
                if((long)((long)i*(long)i) <= max){
                    for(int j = i*i; j <= max; j += i){
                        p[j] = false;
                        spf[j] = Math.min(spf[j] , i);
                    }
                }
            }
        }
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(p[nums[i]])
            adj.put(nums[i] , new ArrayList<>());
        }
        List<Integer>[] pf = new ArrayList[nums.length];
        for(int i = 0; i < nums.length; i++){
            pf[i] = primeFactorization(spf , nums[i]);
        }
        for(int i = 0; i < nums.length; i++){
            for(Integer x : pf[i]){
                if(adj.containsKey(x))
                adj.get(x).add(new int[]{i , nums[i]});
            }
        }
        for(Integer x : adj.keySet()){
            Collections.sort(adj.get(x) , (a , b)->Integer.compare(b[0] , a[0]));
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        q.offer(new int[]{0 , 0});
        visited[0] = true;
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int d = q.peek()[1];
            q.poll();
            if(node == nums.length-1)
            return d;
            if(node-1 >= 0 && !visited[node-1]){
                q.offer(new int[]{node-1 , d+1});
                visited[node-1] = true;
            }
            if(node+1 < nums.length && !visited[node+1]){
                q.offer(new int[]{node+1 , d+1});
                visited[node+1] = true;
            }
            if(p[nums[node]]){
                for(int[] a : adj.get(nums[node])){
                    if(!visited[a[0]]){
                        q.offer(new int[]{a[0] , d+1});
                        visited[a[0]] = true;
                    }
                }
            }
        }
        return -1;
    }
}