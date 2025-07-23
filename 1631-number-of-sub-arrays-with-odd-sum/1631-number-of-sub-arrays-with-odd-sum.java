class Solution {
    final int mod = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int[] ps = new int[arr.length];
        ps[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            ps[i] = ps[i-1]+arr[i];
        }
        int ans = 0;
        int[] e = new int[arr.length];
        int[] o = new int[arr.length];
        if(ps[0]%2 == 0)
        e[0] = 1;
        else
        o[0] = 1;
        for(int i = 1; i < arr.length; i++){
            if(ps[i]%2 == 0){
                e[i] = e[i-1]+1;
                o[i] = o[i-1];
            }else{
                o[i] = o[i-1]+1;
                e[i] = e[i-1];
            }
        }
        if(ps[0]%2 != 0)
        ans++;
        for(int i = 1; i < arr.length; i++){
            if(ps[i]%2 == 0)
            ans = (ans+o[i-1])%mod;
            else
            ans = (ans+e[i-1]+1)%mod;
        }
        /*for(int i = 1; i < arr.length; i++){
            if(arr[i]%2 != 0)
            ans++;
        }*/
        return ans;
    }
}