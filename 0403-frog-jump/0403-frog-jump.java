class Solution {
    boolean solve(int[] stones , HashMap<Integer , Integer> map , int ci , int pj , int[][] dp){
        if(stones[1] > 1)
        return false;
        if(ci == stones.length-1)
        return true;
        if(dp[ci][pj] != -1)
        return dp[ci][pj] == 1;
        boolean ans = false;
        for(int i = pj-1; i <= pj+1; i++){
            if(i > 0){
                if(map.containsKey(stones[ci]+i))
                ans = ans || solve(stones , map , map.get(stones[ci]+i) , i , dp);
            }
        }
        if(ans)
        dp[ci][pj] = 1;
        else
        dp[ci][pj] = 0;
        if(dp[ci][pj] == 1)
        return true;
        else
        return false;
    }
    public boolean canCross(int[] stones) {
        /*if(stones[1] > 1)
        return false;
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[stones.length];
        HashMap<Integer , Set<Integer>> jumps = new HashMap<>();
        for(int i = 0; i < stones.length; i++){
            jumps.put(stones[i] , new HashSet<>());
        }
        visited[0] = true;
        visited[1] = true;
        jumps.get(0).add(1); 
        q.offer(new int[]{1 , 1});
        while(!q.isEmpty()){
            int ci = q.peek()[0];
            int pj = q.peek()[1];
            q.poll();
            int cp = stones[ci];
            if(ci == stones.length-1)
            return true;
            for(int i = pj-1; i <= pj+1; i++){
                if(i > 0){
                int index = Arrays.binarySearch(stones , cp+i);
                if(index != -1 && index >= ci && !visited[index] && !jumps.get(cp).contains(cp+i)){
                    jumps.get(cp).add(cp+i);
                    q.offer(new int[]{index , i});
                    visited[index] = true;
                }
            }
            }
        }
        return false;*/
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < stones.length; i++){
            map.put(stones[i] , i);
        }
        int[][] dp = new int[2001][2001];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(stones , map , 0 , 0 , dp);
    }
}