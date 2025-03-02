class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int s = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < quantities.length; i++){
            max = Math.max(max , quantities[i]);
        }
        int e = max;
        int ans = 0;
        while(s <= e){
            int m = s+(e-s)/2;
            int t = 0;
            for(int i = 0; i < quantities.length; i++){
                t += quantities[i]/m;
                if(quantities[i]%m != 0)
                t += 1;
            }
            if(t <= n){
                ans = m;
                e = m-1;
            }else
            s = m+1;
        }
        return ans;
    }
}