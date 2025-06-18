class Solution {
    int BFS(int x , int y){
        if(y > x){
            return y-x;
        }
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(new int[]{0 , x});
        visited.add(x);
        while(!q.isEmpty()){
            int d = q.peek()[0];
            int n = q.peek()[1];
            q.poll();
            if(n == y){
                return d;
            }
            if(n%11 == 0 && !visited.contains(n/11)){
                q.offer(new int[]{d+1 , n/11});
                visited.add(n/11);
            }
            if(n%5 == 0 && !visited.contains(n/5)){
                q.offer(new int[]{d+1 , n/5});
                visited.add(n/5);
            }
            if(!visited.contains(n-1)){
                q.offer(new int[]{d+1 , n-1});
                visited.add(n-1);
            }
            if(!visited.contains(n+1)){
                q.offer(new int[]{d+1 , n+1});
                visited.add(n+1);
            }
        }
        return -1;
    }
    public int minimumOperationsToMakeEqual(int x, int y) {
        return BFS(x , y);
    }
}