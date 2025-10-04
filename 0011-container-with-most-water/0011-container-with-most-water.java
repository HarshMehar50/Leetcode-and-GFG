class Solution {
    public int maxArea(int[] height) {
        /*int[][] pmax = new int[height.length][2];
        int[][] smax = new int[height.length][2];
        pmax[0][0] = height[0];
        pmax[0][1] = 0;
        smax[smax.length-1][0] = height[height.length-1];
        smax[smax.length-1][1] = height.length-1;
        for(int i = 1; i < pmax.length; i++){
            if(pmax[i-1][0] < height[i]){
                pmax[i][0] = height[i];
                pmax[i][1] = i;
            }else{
                pmax[i][0] = pmax[i-1][0];
                pmax[i][1] = pmax[i-1][1];
            }
        }
        for(int i = smax.length-2; i >= 0; i--){
            if(smax[i+1][0] < height[i]){
                smax[i][0] = height[i];
                smax[i][1] = i;
            }else{
                smax[i][0] = smax[i+1][0];
                smax[i][1] = smax[i+1][1];
            }
        }
        int ans = 0;
        for(int i = 0; i < pmax.length-1; i++){
            ans = Math.max(ans , Math.min(pmax[i][0] , smax[i+1][0])*(smax[i][1]-pmax[i][1]));
        }
        return ans;*/
        int l = 0;
        int r = height.length-1;
        int ans = 0;
        while(l <= r){
            ans = Math.max(ans , Math.min(height[l] , height[r])*(r-l));
            if(height[l] < height[r])
            l++;
            else
            r--;
        }
        return ans;
    }
}