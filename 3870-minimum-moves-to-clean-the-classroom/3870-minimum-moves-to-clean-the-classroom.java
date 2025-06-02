class Solution {
    public int minMoves(String[] classroom, int energy) {
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        Queue<int[]> q = new LinkedList<>();
        int sr = -1;
        int sc = -1;
        List<int[]> l = new ArrayList<>();
        for(int i = 0; i < classroom.length; i++){
            for(int j = 0; j < classroom[0].length(); j++){
                if(classroom[i].charAt(j) == 'S'){
                    sr = i;
                    sc = j;
                }
                if(classroom[i].charAt(j) == 'L')
                l.add(new int[]{i , j});
            }
        }
        int[][][] visited = new int[classroom.length][classroom[0].length()][1025];
        for(int[][] a : visited){
            for(int i = 0; i < a.length; i++){
                Arrays.fill(a[i] , -1);
            }
        }
        q.offer(new int[]{sr , sc , 0 , energy , 0});
        visited[sr][sc][0] = energy;
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int mask = q.peek()[2];
            int e = q.peek()[3];
            int distance = q.peek()[4];
            q.poll();
            if(mask == (1<<l.size())-1)
            return distance;
            if(e == 0)
            continue;
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                int ne = e-1;
                int nmask = mask;
                if(nr < classroom.length && nr >= 0 && nc < classroom[0].length() && nc >= 0 && classroom[nr].charAt(nc) != 'X'){
                    if(classroom[nr].charAt(nc) == 'R')
                    ne = energy;
                    if(classroom[nr].charAt(nc) == 'L'){
                        int k = -1;
                        for(int j = 0; j < l.size(); j++){
                            if(l.get(j)[0] == nr && l.get(j)[1] == nc){
                                k = j;
                                break;
                            }
                        }
                        if(k != -1 && (nmask&(1<<k)) == 0)
                        nmask = nmask|(1<<k);
                    }
                    if(ne >= 0 && visited[nr][nc][nmask] < ne){
                        q.offer(new int[]{nr , nc , nmask , ne , distance+1});
                        visited[nr][nc][nmask] = ne;
                    }
                }
            }
        }
        return -1;
    }
}