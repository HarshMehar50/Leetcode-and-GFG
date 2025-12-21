class Solution {
    public long minCost(String s, int[] cost) {
        long s1 = 0;
        long[] map = new long[26];
        for(int i = 0; i < cost.length; i++){
            s1 += cost[i];
            map[s.charAt(i)-'a'] += cost[i];
        }
        long ans = (long)(1e15);
        for(int i = 0; i < 26; i++){
            if(map[i] != 0)
            ans = Math.min(ans , s1-map[i]);
        }
        return ans;
    }
}