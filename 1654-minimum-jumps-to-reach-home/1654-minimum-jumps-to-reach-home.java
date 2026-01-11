class Solution {
    /*int solve(int[] forbidden , int a , int b , int i , int bj){
        if(i == 0)
        return 0;
        int forward = Integer.MAX_VALUE;
        int backward = Integer.MAX_VALUE;
        int ji = Arrays.binarySearch(forbidden , i+a);
        if(!(ji >= 0 && ji < forbidden.length) && i+a >= 0)
        forward = 1+solve(forbidden , a , b , i+a , 1);
        int jib = Arrays.binarySearch(forbidden , i-b);
        if(bj == 1 && i-b >= 0 && !(jib >= 0 && jib < forbidden.length))
        backward = 1+solve(forbidden , a , b , i-b , 0);
        int ans = Math.min(forward , backward);
        return ans;
    }*/
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        /*Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[1000001][2];
        Arrays.sort(forbidden);
        q.offer(new int[]{0 , 0 , 0});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int jump = q.peek()[1];
            int d = q.peek()[2];
            q.poll();
            System.out.println(node);
            if(node == x)
            return d;
            if(jump == 0){
                if(!visited[node+a][0]){
                    int bs = Arrays.binarySearch(forbidden , node+a);
                    if(bs < 0 || bs >= forbidden.length){ 
                    q.offer(new int[]{node+a , 0 , d+1});
                    visited[node+a][0] = true;
                    }
                }
                if(node-b >= 0 && !visited[node-b][1]){
                    int bs = Arrays.binarySearch(forbidden , node-b);
                    if(bs < 0 || bs >= forbidden.length){ 
                    q.offer(new int[]{node-b , 1 , d+1});
                    visited[node-b][1] = true;
                    }
                }
            }else{
                if(!visited[node+a][0]){
                    int bs = Arrays.binarySearch(forbidden , node+a);
                    if(bs < 0 || bs >= forbidden.length){ 
                    q.offer(new int[]{node+a , 0 , d+1});
                    visited[node+a][0] = true;
                    }
                }
            }
        }
        return -1;*/
        /*Arrays.sort(forbidden);
        int ans = solve(forbidden , a , b , x , 1);
        if(ans == Integer.MAX_VALUE)
        return -1;
        return ans;*/
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