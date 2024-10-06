class Solution {
   /* int solve(int x  , int y , int c1){
        if(y >= x){
            return y-x;
        }
        if(x == y){
            return c1;
        }
        int a = 0;
        int b = 0;
        int c = 0;
        if(x%11 == 0)
        a = solve(x/11 , y , c1+1);
        else if(x%5 == 0)
        b = solve(x/5 , y , c1+1);
        else
        c = solve(x-1 , y , c1+1);

        int ans = 1+Math.min(a , Math.min(b , c));
        return ans;

    }*/
   /* int solve(int x , int y){
        if(y > x){
            return y-x;
        }
        if(x == y){
            return 0;
        }
        int a = 0;
        int b = 0;
        int c = 0;
        if(x%11 == 0){
            a = solve(x/11 , y);
        }else if(x%5 == 0){
            b = solve(x/5 , y);
        }else{
            c = solve(x-1 , y);
        }
        int ans = 1+ Math.min(a , Math.min(b , c));
        return ans;
    }*/
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