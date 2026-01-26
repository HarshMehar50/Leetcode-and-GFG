class Solution {
    int solve(int num , int k , int s , HashMap<Pair<Integer , Integer> , Integer> dp){
        if(num == 0)
        return s;
        if(dp.containsKey(new Pair<>(num , s)))
        return dp.get(new Pair<>(num , s));
        int ans = Integer.MAX_VALUE;
        for(int i = k; i <= num; i += 10){
            if(i != 0)
            ans = Math.min(ans , solve(num-i , k , s+1 , dp));
        }
        dp.put(new Pair<>(num , s) , ans);
        return dp.get(new Pair<>(num , s));
    }
    public int minimumNumbers(int num, int k) {
        HashMap<Pair<Integer , Integer> , Integer> dp = new HashMap<>();
        int ans = solve(num , k , 0 , dp);
        if(ans == Integer.MAX_VALUE)
        return -1;
        return ans;
    }
}