class Solution {
    int solve(int n , int i , boolean[] used){
        if(i >= n)
        return 1;
        int ans = 0;
        for(int j = 1; j <= n; j++){
            if(!used[j] && (j%(i+1) == 0 || (i+1)%j == 0)){
                used[j] = true;
                ans += solve(n , i+1 , used);
                used[j] = false;
            }
        }
        /*for(int j = 1; j <= n; j++){
            if(!used[j] && (i+1)%j == 0){
                used[j] = true;
                ans += solve(n , i+1 , used);
                used[j] = false;
            }
        }*/
        return ans;
    }
    public int countArrangement(int n) {
        boolean[] used = new boolean[n+1];
        return solve(n , 0 , used);
    }
}