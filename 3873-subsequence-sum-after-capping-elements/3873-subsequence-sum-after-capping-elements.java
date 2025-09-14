class Solution {
    int floor(int[] a , int x){
        int s = 0;
        int e = a.length-1;
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(a[m] <= x){
                ans = m;
                s = m+1;
            }else
                e = m-1;
        }
        return ans;
    }
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        Arrays.sort(nums);
        boolean[] ans = new boolean[nums.length];
        boolean[][] dp = new boolean[nums.length][k+1];
        for(int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }
        if(nums[0] <= k)
            dp[0][nums[0]] = true;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j <= k; j++){
                boolean include = false;
                if(j >= nums[i])
                    include = dp[i-1][j-nums[i]];
                dp[i][j] = include||dp[i-1][j];
            }
        }
        for(int i = 0; i < nums.length; i++){
            int x = i+1;
            int fl = floor(nums , x);
            /*for(int f = 0; f*x <= k; f++){
                int rs = k-(f*x);
                for(int j = fl+1; j < nums.length; j++){
                    if(dp[j][rs]){
                        ans[i] = true;
                        break;
                    }
                }
                if(ans[i])
                    break;
            }*/
            if(fl == -1){
                if(k%x == 0 && k/x <= nums.length)
                ans[i] = true;
            }else{
            for(int f = 0; f*x <= k && f <= nums.length-fl-1; f++){
                int rs = k-(f*x);
                /*for(int j = 0; j <= fl; j++){
                    if(dp[j][rs]){
                        ans[i] = true;
                        break;
                    }
                }
                if(ans[i])
                    break;*/
                    if(fl != -1 && dp[fl][rs]){
                        ans[i] = true;
                        break;
                    }
            }
            }
        }
        return ans;
    }
}