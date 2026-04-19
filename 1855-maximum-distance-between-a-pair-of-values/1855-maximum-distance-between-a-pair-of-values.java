class Solution {
    int ceil(int[][] a , int x){
        int s = 0;
        int e = a.length-1;
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(a[m][0] < x)
            s = m+1;
            else{
                ans = m;
                e = m-1;
            }
        }
        return ans;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int[][] a = new int[nums2.length][2];
        for(int i = 0; i < nums2.length; i++){
            a[i][0] = nums2[i];
            a[i][1] = i;
        }
        Arrays.sort(a , (x , y)->Integer.compare(x[0] , y[0]));
        int[] smax = new int[a.length];
        int[] smin = new int[a.length];
        smax[a.length-1] = a[a.length-1][1];
        smin[a.length-1] = a[a.length-1][1];
        for(int i = a.length-2; i >= 0; i--){
            smax[i] = Math.max(smax[i+1] , a[i][1]);
            smin[i] = Math.min(smin[i+1] , a[i][1]);
        }
        int ans = 0;
        for(int i = 0; i < nums1.length; i++){
            int c = ceil(a , nums1[i]);
            if(c != -1)
            ans = Math.max(ans , Math.max(smax[c]-i , smin[c]-i));
        }
        return ans;
    }
}