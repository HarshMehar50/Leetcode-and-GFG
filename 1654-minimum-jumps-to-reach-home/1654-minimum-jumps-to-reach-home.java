class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Arrays.sort(forbidden);
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[8000][2];
        q.offer(new int[]{0 , 0 , 1});
        visited[0][1] = true;
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int d = q.peek()[1];
            int bj = q.peek()[2];
            q.poll();
            if(node == x)
            return d;
            int i1 = Arrays.binarySearch(forbidden , node+a);
            if(i1 < 0 || i1 >= forbidden.length){
                if(node+a < 8000 && !visited[node+a][1]){
                    q.offer(new int[]{node+a , d+1 , 1});
                    visited[node+a][1] = true;
                }
            }
            int i2 = Arrays.binarySearch(forbidden , node-b);
            if(i2 < 0 || i2 >= forbidden.length){
                if(bj == 1 && node-b >= 0 && !visited[node-b][0]){
                    q.offer(new int[]{node-b , d+1 , 0});
                    visited[node-b][0] = true;
                }
            }
        }
        return -1;
    }
}