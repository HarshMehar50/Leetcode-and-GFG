class Solution {
    public int minOperations(String s, int k) {
        int c1 = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1')
            c1++;
        }
        /*boolean[] visited = new boolean[s.length()+1];
        Queue<int[]> q = new LinkedList<>();
        visited[s.length()-c1] = true;
        q.offer(new int[]{s.length()-c1 , 0});
        while(!q.isEmpty()){
            int zero = q.peek()[0];
            int cost = q.peek()[1];
            int one = s.length()-zero;
            q.poll();
            if(zero == 0)
            return cost;
            for(int i = Math.max(0 , k-one); i <= Math.min(k , zero); i++){
                int nz = zero+k-(2*i);
                if(!visited[nz]){
                    q.offer(new int[]{nz , cost+1});
                    visited[nz] = true;
                }
            }
        }*/
        TreeSet<Integer> ets = new TreeSet<>();
        TreeSet<Integer> ots = new TreeSet<>();
        for(int i = 0; i <= s.length(); i++){
            if(i%2 == 0)
            ets.add(i);
            else
            ots.add(i);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s.length()-c1 , 0});
        if((s.length()-c1)%2 == 0)
        ets.remove(s.length()-c1);
        else
        ots.remove(s.length()-c1);
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int c = q.peek()[1];
            q.poll();
            if(node == 0)
            return c;
            int l = node+k-(2*Math.min(k , node));
            int r = node+k-(2*Math.max(0 , k-(s.length()-node)));
            if((node+k)%2 == 0){
                Integer nn = ets.ceiling(l);
                while(nn != null && nn <= r){
                    q.offer(new int[]{nn , c+1});
                    ets.remove(nn);
                    nn = ets.ceiling(l);
                }
            }else{
                Integer nn = ots.ceiling(l);
                while(nn != null && nn <= r){
                    q.offer(new int[]{nn , c+1});
                    ots.remove(nn);
                    nn = ots.ceiling(l);
                }
            }
        }
        return -1;
    }
}