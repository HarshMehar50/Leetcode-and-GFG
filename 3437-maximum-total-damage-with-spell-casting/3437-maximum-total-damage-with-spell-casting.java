class Solution {
    long solve(List<Integer> l , int i , TreeMap<Integer , Integer> map , long[] dp){
        if(i >= l.size())
        return 0;
        if(dp[i] != -1)
        return dp[i];
        int j = i;
        while(j < l.size() && l.get(j) <= l.get(i)+2){
            j++;
        }
        long include = (long)((long)map.get(l.get(i))*(long)l.get(i))+solve(l , j , map , dp);
        long exclude = solve(l , i+1 , map , dp);
        long ans = Math.max(include , exclude);
        dp[i] = ans;
        return dp[i];
    }
    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer , Integer> map = new TreeMap<>();
        for(int i = 0; i < power.length; i++){
            map.put(power[i] , map.getOrDefault(power[i] , 0)+1);
        }
        List<Integer> l = new ArrayList<>(map.keySet());
        long[] dp = new long[l.size()+1];
        Arrays.fill(dp , -1);
        return solve(l , 0 , map , dp);
    }
}