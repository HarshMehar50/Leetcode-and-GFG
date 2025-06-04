class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] a = new int[n];
        int ans = 0;
        for(int mask = 0; mask < (1<<requests.length); mask++){
            for(int i = 0; i < requests.length; i++){
                if((mask&(1<<i)) != 0){
                    a[requests[i][0]]--;
                    a[requests[i][1]]++;
                }
            }
            boolean t = true;
            for(int i = 0; i < n; i++){
                if(a[i] != 0)
                t = false;
            }
            if(t)
            ans = Math.max(ans , Integer.bitCount(mask));
            Arrays.fill(a , 0);
        }
        return ans;
    }
}