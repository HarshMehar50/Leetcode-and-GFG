class Solution {
    int solve(int k , int jump , int t , int target , HashMap<String , Integer> dp){
        if(k > target+1)
        return 0;
        String s = k+" "+jump+" "+t;
        if(dp.containsKey(s))
        return dp.get(s);
        int ans = 0;
        if(k == target)
        ans++;
        if(t == 1 && k > 0){
            ans += solve(k-1 , jump , 0 , target , dp);
        }
        ans += solve(k+(1<<jump) , jump+1 , 1 , target , dp);
        dp.put(s , ans);
        return dp.get(s);
    }
    public int waysToReachStair(int k) {
        HashMap<String , Integer> dp = new HashMap<>();
        return solve(1 , 0 , 1 , k , dp);
    }
}