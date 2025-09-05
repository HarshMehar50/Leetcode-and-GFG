class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int[] dp1 = new int[arr.length];
        int[] dp2 = new int[arr.length];
        Arrays.fill(dp1 , 1);
        Arrays.fill(dp2 , 1);
        int pc = 0;
        for(int i = 1; i < arr.length; i++){
            /*if(pc == 0){
                if(arr[i] > arr[i-1]){
                    dp[i] += dp[i-1];
                    pc = 1;
                }else if(arr[i] < arr[i-1]){
                    dp[i] += dp[i-1];
                    pc = -1;
                }
            }else if(pc == 1){
                if(arr[i] < arr[i-1]){
                    dp[i] += dp[i-1];
                    pc = -1;
                }else
                pc = 0;
            }else{
                if(arr[i] > arr[i-1]){
                    dp[i] += dp[i-1];
                    pc = 1;
                }else
                pc = 0;
            }*/
            if(arr[i] > arr[i-1])
            dp1[i] += dp2[i-1];
            else if(arr[i] < arr[i-1])
            dp2[i] += dp1[i-1];
        }
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            ans = Math.max(ans , Math.max(dp1[i] , dp2[i]));
        }
        return ans;
    }
}