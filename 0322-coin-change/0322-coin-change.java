class Solution {
    /*int solve(int[] coins , int amount){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            min = Math.min(min , coins[i]);
        }
        if(min > amount){
            if(amount != 0)
            return -1;
            else
            return 0;
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[amount+1];
        for(int i = 0; i < coins.length; i++){
            if(coins[i] > 0 && coins[i] <= 10000 && coins[i] <= amount){
            q.offer(new int[]{coins[i] , 1});
            visited[coins[i]] = true;
            }
        }
        while(!q.isEmpty()){
            int camt = q.peek()[0];
            int c = q.peek()[1];
            q.poll();
            if(camt == amount)
            return c;
            for(int i = 0; i < coins.length; i++){
                if(camt+coins[i] <= amount && !visited[camt+coins[i]]){
                    q.offer(new int[]{camt+coins[i] , c+1});
                    visited[camt+coins[i]] = true;
                }
            }
        }
        return -1;
    }*/
    int BFS(int[] coins , int amount){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[amount+1];
        q.offer(amount);
        visited[amount] = true;
        int ans = 0;
        while(!q.isEmpty()){
            int l = q.size();
            for(int i = 0; i < l; i++){
                int ca = q.poll();
                if(ca == 0)
                    return ans;
                if(ca < 0) continue;
                for(int j = 0; j < coins.length; j++){
                    if(ca-coins[i] >= 0 && !visited[ca-coins[i]]){
                        q.offer(ca-coins[i]);
                        visited[ca-coins[i]] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
    public int coinChange(int[] coins, int amount) {
        /*int[] dp = new int[amount+1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = -1;
        }
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < coins.length; j++){
                if((i-coins[j]) >= 0){
                dp[i] = Math.min(dp[i] , 1+dp[i-coins[j]]);
                }
            }
        }
        if(dp[amount] != -1)
        return dp[amount];
        else 
        return -1;*/
        //return solve(coins , amount);
        //return BFS(coins , amount);
        int dp[] = new int[amount+1];
        for(int i=0;i<amount+1;i++){
            dp[i]=amount+1;
        }
        dp[0]=0;
        int a;
        for(a=1;a<amount+1;a++){
            for(int c:coins){
                if(a-c>=0)
                dp[a]=Math.min(dp[a],1+dp[a-c]);
            }
        }
        if(dp[amount]!=amount+1)
            return dp[amount];
        else
            return -1;
    }
}