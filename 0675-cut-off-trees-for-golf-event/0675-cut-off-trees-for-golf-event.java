class Solution {
    int BFS(List<List<Integer>> forest , int sr , int sc , int dr , int dc){
        if(sr == dr && sc == dc)
        return 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        q.offer(new int[]{sr , sc , 0});
        visited[sr][sc] = true;
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int d = q.peek()[2];
            q.poll();
            if(r == dr && c == dc)
            return d;
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr >= 0 && nr < forest.size() && nc >= 0 && nc < forest.get(0).size() && !visited[nr][nc] && forest.get(nr).get(nc) != 0){
                    q.offer(new int[]{nr , nc , d+1});
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }
    public int cutOffTree(List<List<Integer>> forest) {
        /*Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        int c1 = 0;
        for(List<Integer> l : forest){
            for(Integer x : l){
                if(x > 1)
                c1++;
            }
        }
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        int t = 0;
        if(forest.get(0).get(0) > 1)
        t = 1;
        q.offer(new int[]{0 , 0 , 0 , t});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int d = q.peek()[2];
            int ct = q.peek()[3];
            q.poll();
            if(ct == c1)
            return d;
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr >= 0 && nr < forest.size() && nc >= 0 && nc < forest.get(0).size() && !visited[nr][nc] && forest.get(nr).get(nc) != 0){
                    if(forest.get(nr).get(nc) > forest.get(r).get(c)){
                        q.offer(new int[]{nr , nc , d+1 , ct+1});
                        visited[nr][nc] = true;
                    }
                    q.offer(new int[]{nr , nc , d+1 , ct});
                }
            }
        }
        return -1;*/
        List<int[]> l = new ArrayList<>();
        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(i).size(); j++){
                if(forest.get(i).get(j) > 1)
                l.add(new int[]{forest.get(i).get(j) , i , j});
            }
        }
        Collections.sort(l , (x , y)->Integer.compare(x[0] , y[0]));
        int ans = 0;
        int sr = 0;
        int sc = 0;
        for(int[] a : l){
            int d = BFS(forest , sr , sc , a[1] , a[2]);
            if(d == -1)
            return -1;
            ans += d;
            sr = a[1];
            sc = a[2];
        }
        return ans;
    }
}