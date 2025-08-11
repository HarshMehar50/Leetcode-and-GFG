class Solution {
    final int mod = 1000000007;
    long binExpo(long a , long b){
        long ans = 1;
        a = a%mod;
        while(b > 0){
            if((b&1) == 1)
            ans = (ans*a)%mod;
            a = (a*a)%mod;
            b = (b>>1);
        }
        return ans;
    }
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i <= 31; i++){
            if((n&(1<<i)) != 0)
            l.add(i);
        }
        int[] ps = new int[l.size()];
        ps[0] = l.get(0);
        for(int i = 1; i < l.size(); i++){
            ps[i] = ps[i-1]+l.get(i);
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < ans.length; i++){
            long ss = 0;
            if(queries[i][0] == 0)
            ss = ps[queries[i][1]];
            else
            ss = ps[queries[i][1]]-ps[queries[i][0]-1];
            ans[i] = (int)binExpo(2 , ss)%mod;
        }
        return ans;
    }
}