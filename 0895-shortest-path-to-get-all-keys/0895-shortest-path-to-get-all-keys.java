class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int keys = 0;
        int sr = 0;
        int sc = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length(); j++){
                if(grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f')
                keys = keys|(1<<(grid[i].charAt(j)-'a'));
                if(grid[i].charAt(j) == '@'){
                    sr = i;
                    sc = j;
                }
            }
        }
        //PriorityQueue<int[]> q = new PriorityQueue<int[]>((x , y)->Integer.compare(x[3] , y[3]));
        Queue<int[]> q = new LinkedList<>();
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        boolean[][][] visited = new boolean[grid.length][grid[0].length()][64];
        q.offer(new int[]{sr , sc , 0 , 0});
        visited[sr][sc][0] = true;
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int mask = q.peek()[2];
            int distance = q.peek()[3];
            q.poll();
            if(mask == keys)
            return distance;
            for(int i = 0; i < 4; i++){
                /*int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < grid.length && nr >= 0 && nc < grid[0].length() && nc >= 0 && grid[nr].charAt(nc) != '#'){
                    if(grid[nr].charAt(nc) == '.' && !visited[nr][nc][mask]){
                        visited[nr][nc][mask] = true;
                        q.offer(new int[]{nr , nc , mask , distance+1});
                    }else if(grid[nr].charAt(nc) >= 'A' && grid[nr].charAt(nc) <= 'F'){
                        int kp = (int)(grid[nr].charAt(nc)-'A');
                        if((mask&(1<<kp)) != 0 && !visited[nr][nc][mask]){
                            visited[nr][nc][mask] = true;
                            q.offer(new int[]{nr , nc , mask , distance+1});
                        }
                    }else if(grid[nr].charAt(nc) >= 'a' && grid[nr].charAt(nc) <= 'f'){
                        int kp = (int)(grid[nr].charAt(nc)-'a');
                        int nmask = mask|(1<<kp);
                        if(!visited[nr][nc][nmask]){
                            visited[nr][nc][nmask] = true;
                            q.offer(new int[]{nr , nc , nmask , distance+1});
                        }
                    }
                }*/
                int nr = r+dR[i];
                int nc = c+dC[i];
                int nmask = mask;
                if(nr < grid.length && nr >= 0 && nc < grid[0].length() && nc >= 0 && grid[nr].charAt(nc) != '#'){
                    if(grid[nr].charAt(nc) >= 'A' && grid[nr].charAt(nc) <= 'F'){
                        int kp = (int)(grid[nr].charAt(nc)-'A');
                        if((mask&(1<<kp)) == 0)
                        continue;
                    }
                    if(grid[nr].charAt(nc) >= 'a' && grid[nr].charAt(nc) <= 'f'){
                        int kp = (int)(grid[nr].charAt(nc)-'a');
                        nmask = nmask|(1<<kp);
                    }
                    if(!visited[nr][nc][nmask]){
                        visited[nr][nc][nmask] = true;
                        q.offer(new int[]{nr , nc , nmask , distance+1});
                    }
                }
            }
        }
        return -1;
    }
}