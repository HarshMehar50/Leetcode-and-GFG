class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int s = 1;
        int e = 10000000;
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            double h = 0;
            for(int i = 0; i < dist.length-1; i++){
                h += Math.ceil((double)((double)dist[i]/(double)m));
            }
            h += (double)((double)dist[dist.length-1]/(double)m);
            if(h <= hour){
                ans = m;
                e = m-1;
            }else
            s = m+1;
        }
        return ans;
    }
}