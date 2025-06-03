class Solution {
    int solveHash(int[] arr){
        if(arr.length < 3)
            return 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i] , i);
        }
        int ans = 0;
        int[][] dp = new int[arr.length][arr.length];
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(map.containsKey(arr[i]-arr[j]) && map.get(arr[i]-arr[j]) < j){
                    dp[j][i] = dp[map.get(arr[i]-arr[j])][j]+1;
                    ans = Math.max(dp[j][i]+2 , ans);
                }else
                    dp[j][i] = 0;
            }
        }
        if(ans >= 3)
            return ans;
        else return 0;
    }
    int solve(int[] arr , int c , int p1 , int p2 , int[][] dp){
        if(c == arr.length){
            return 0;
        }
        if(dp[p1+1][p2+1] != -1){
            return dp[p1+1][p2+1];
        }
        int include = 0;
        if((p1 == -1 || p2 == -1)||(arr[p1]+arr[p2] == arr[c] && p1 != -1 && p2 != -1))
            include = 1+solve(arr , c+1 , c , p1 , dp);
        int exclude = solve(arr , c+1 , p1 , p2 , dp);
        int ans = Math.max(include , exclude);
        dp[p1+1][p2+1] = ans;
        return dp[p1+1][p2+1];
    }
    public int lenLongestFibSubseq(int[] arr) {
        /*int[][] dp = new int[arr.length+1][arr.length+1];
        for(int i = 0; i < dp.length; i++){
                Arrays.fill(dp[i] , -1);
        }
        int ans = solve(arr , 0 , -1 , -1 , dp);
        if(arr.length == 3 && arr[0]+arr[1] != arr[2])
        return 0;
        else if(arr.length == 3 && arr[0]+arr[1] == arr[2])
        return 3;
        else if(ans == 2)
        return 0;
        else
        return ans;*/
        return solveHash(arr);
    }
}