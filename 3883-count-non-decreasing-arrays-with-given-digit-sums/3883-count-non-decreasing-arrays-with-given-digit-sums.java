class Solution {
    final int mod = 1000000007;
    /*int ceil(int x , List<Integer> l){
        int s = 0;
        int e = l.size()-1;
        int c = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(l.get(m) < x)
            s = m+1;
            else{
                c = m;
                e = m-1;
            }
        }
        return c;
    }
    int solve(int[] digitSum , List<Integer>[] l , int i , int p , int[][] dp){
        if(i >= digitSum.length)
        return 1;
        if(dp[i][p+1] != -1)
        return dp[i][p+1];
        int ans = 0;
        int si = ceil(p , l[digitSum[i]]);
        if(si != -1){
        for(int j = si; j < l[digitSum[i]].size(); j++){
            if(l[digitSum[i]].get(j) >= p)
            ans = (ans+solve(digitSum , l , i+1 , l[digitSum[i]].get(j) , dp))%mod;
        }
        }
        dp[i][p+1] = ans;
        return dp[i][p+1];
    }*/
    boolean contains(List<Integer> l , int x){
        int s = 0;
        int e = l.size()-1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(l.get(m) == x)
            return true;
            if(l.get(m) < x)
            s = m+1;
            else
            e = m-1;
        }
        return false;
    }
    boolean check(int n , int s){
        int ds = 0;
        for(int i = n; i > 0; i = i/10){
            ds += i%10;
        }
        return (ds == s);
    }
    int solve(int[] digitSum , List<Integer>[] l , int i , int p , int[][] dp){
        if(i >= digitSum.length)
        return 1;
        if(dp[i][p] != -1)
        return dp[i][p];
        int ans = 0;
        if(check(p , digitSum[i]))
        ans = (ans+solve(digitSum , l , i+1 , p , dp))%mod;
        if(p+1 <= 5000)
        ans = (ans+solve(digitSum , l , i , p+1 , dp))%mod;
        dp[i][p] = ans;
        return dp[i][p];
    }
    public int countArrays(int[] digitSum) {
        int max = 0;
        for(int i = 0; i < digitSum.length; i++){
            max = Math.max(max , digitSum[i]);
        }
        List<Integer>[] l = new ArrayList[max+1];
        for(int i = 0; i <= max; i++){
            l[i] = new ArrayList<>();
        }
        for(int i = 0; i <= 5000; i++){
            int ds = 0;
            for(int j = i; j > 0; j = j/10){
                ds += j%10;
            }
            if(ds <= max)
            l[ds].add(i);
        }
        /*int[][] dp = new int[digitSum.length+1][5002];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return solve(digitSum , l , 0 , -1 , dp);*/
        /*for(int i = 0; i <= 5000; i++){
            dp[digitSum.length][i] = 1;
        }
        for(int i = digitSum.length-1; i >= 0; i--){
            int[] ss = new int[l[digitSum[i]].size()+1];
            for(int j = l[digitSum[i]].size()-1; j >= 0; j--){
                ss[j] = (dp[i+1][l[digitSum[i]].get(j)]+ss[j+1])%mod;
            }
            for(int j = 0; j <= 5000; j++){
                int index = ceil(j , l[digitSum[i]]);
                if(index < l[digitSum[i]].size())
                dp[i][j] = ss[index];
                else
                dp[i][j] = 0;
            }
        }
        return dp[0][0];*/
        int[][] dp = new int[digitSum.length][5002];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return solve(digitSum , l , 0 , 0 , dp);
    }
}