class Solution {
    public int maximumSum(int[] arr) {
        /*int ans = Integer.MIN_VALUE;
        int[] msl = new int[arr.length];
        int[] msr = new int[arr.length];
        int csl = 0;
        int ms = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            csl = Math.max(arr[i] , csl+arr[i]);
            ms = Math.max(ms , csl);
            msl[i] = ms;
        }
        int csr = 0;
        ms = Integer.MIN_VALUE;
        for(int i = arr.length-1; i >= 0; i--){
            csr = Math.max(arr[i] , csr+arr[i]);
            ms = Math.max(ms , csr);
            msr[i] = ms;
        } 
        for(int i = 0; i < arr.length; i++){
            int ls = Integer.MIN_VALUE;
            if(i != 0)
            ls = msl[i-1];
            int rs = Integer.MIN_VALUE;
            if(i != arr.length-1)
            rs = msr[i+1];
            ans = Math.max(ans , Math.max(ls+rs , Math.max(ls , rs))) ;
        }
        ans = Math.max(ans , msl[msl.length-1]);
        ans = Math.max(ans , msr[0]);
        return ans;*/
        
        int[] lss = new int[arr.length];
        int[] rss = new int[arr.length];
        lss[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            lss[i] = Math.max(arr[i] , lss[i-1]+arr[i]);
        }
        rss[rss.length-1] = arr[arr.length-1];
        for(int i = rss.length-2; i >= 0; i--){
            rss[i] = Math.max(arr[i] , rss[i+1]+arr[i]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < lss.length; i++){
            ans = Math.max(ans , lss[i]);
        }
        for(int i = 1; i < arr.length-1; i++){
            ans = Math.max(ans , lss[i-1]+rss[i+1]);
        }
        return ans;
    }
}