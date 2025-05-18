class Solution {
    public int minMoves(String[] matrix) {
        if(matrix[matrix.length-1].charAt(matrix[0].length()-1) == '#')
            return -1;
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[2] , y[2]));
        HashMap<Character , List<int[]>> map = new HashMap<>();
        int[][] d = new int[matrix.length][matrix[0].length()];
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < d.length; i++){
            Arrays.fill(d[i] , Integer.MAX_VALUE);
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length(); j++){
                if(matrix[i].charAt(j) >= 'A' && matrix[i].charAt(j) <= 'Z')
                    map.put(matrix[i].charAt(j) , new ArrayList<>());
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length(); j++){
                if(matrix[i].charAt(j) >= 'A' && matrix[i].charAt(j) <= 'Z')
                    map.get(matrix[i].charAt(j)).add(new int[]{i , j});
            }
        }
        d[0][0] = 0;
        pq.offer(new int[]{0 , 0 , 0});
        while(!pq.isEmpty()){
            int r = pq.peek()[0];
            int c = pq.peek()[1];
            int distance = pq.peek()[2];
            pq.poll();
            if(distance > d[r][c])
                continue;
            if(r == matrix.length-1 && c == matrix[0].length()-1)
                return distance;
            if(matrix[r].charAt(c) >= 'A' && matrix[r].charAt(c) <= 'Z' && !set.contains(matrix[r].charAt(c))){
                set.add(matrix[r].charAt(c));
                for(int[] a : map.get(matrix[r].charAt(c))){
                    int nr = a[0];
                    int nc = a[1];
                    if(d[nr][nc] > distance){
                        d[nr][nc] = distance;
                        pq.offer(new int[]{nr , nc , d[nr][nc]});
                    }
                }
            }
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < matrix.length && nr >= 0 && nc < matrix[0].length() && nc >= 0 && matrix[nr].charAt(nc) != '#' && d[nr][nc] > distance+1){
                    d[nr][nc] = distance+1;
                    pq.offer(new int[]{nr , nc , d[nr][nc]});
                }
            }
        }
        return -1;
    }
}