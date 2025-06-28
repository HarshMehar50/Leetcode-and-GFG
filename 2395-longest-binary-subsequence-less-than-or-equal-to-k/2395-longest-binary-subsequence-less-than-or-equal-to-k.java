class Solution {
    /*int solve(String s , int k , int i , int n , HashMap<Pair<Integer , Integer> , Integer> dp){
        if(i >= s.length() || n > k)
        return 0;
        if(dp.containsKey(new Pair<>(i , n)))
        return dp.get(new Pair<>(i , n));
        int include = 0;
        int t = 0;
        if(s.charAt(i) == '0')
        t = 2*n;
        else
        t = (2*n)+1;
        if(t <= k)
        include = 1+solve(s , k , i+1 , t , dp);
        int exclude = solve(s , k , i+1 , n , dp);
        int ans = Math.max(include , exclude);
        dp.put(new Pair<>(i , n) , ans);
        return dp.get(new Pair<>(i , n));
    }*/
    /*long value(String s){
        if(s.equals(""))
        return 0;
        long ans = 0;
        for(int i = s.length()-1; i >= 0; i--){
            ans += (int)(s.charAt(i)-'0')*(long)(1<<i);
        }
        return ans;
    }
    int solve(String s , int k , int i , String cs , int[] dp){
        long v = value(cs);
        if(i >= s.length() || v > k)
        return 0;
        if(dp[i] != -1)
        return dp[i];
        int include = 0;
        if(s.charAt(i) == '0')
        v = 2*v;
        else
        v = (2*v)+1;
        if(v <= k){
            String t = cs;
            t += s.charAt(i);
            include = 1+solve(s , k , i+1 , t , dp);
        }
        int exclude = solve(s , k , i+1 , cs , dp);
        int ans = Math.max(include , exclude);
        dp[i] = ans;
        return dp[i];
    }*/
    public int longestSubsequence(String s, int k) {
        /*HashMap<Pair<Integer , Integer> , Integer> dp = new HashMap<>();
        return solve(s , k , 0 , 0 , dp);*/
        /*int[] dp = new int[s.length()];
        Arrays.fill(dp , -1); 
        return solve(s , k , 0 , "" , dp);*/
        int ans = 0;
        int p = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == '0')
            ans++;
            else{
                if(p < 32 && k-(1<<p) >= 0){
                    k = k-(1<<p);
                    ans++;
                }         
            }
            p++;
        }
        return ans;
    }
}