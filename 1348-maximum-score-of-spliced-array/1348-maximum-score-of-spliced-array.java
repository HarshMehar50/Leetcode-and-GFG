class Solution {
    int kadane(int[] a){
        int s = a[0];
        int maxs = a[0];
        for(int i = 1; i < a.length; i++){
            maxs = Math.max(maxs+a[i] , a[i]);
            s = Math.max(s , maxs);
        }
        return s;
    }
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        /*int[] ps1 = new int[nums1.length];
        int[] ps2 = new int[nums2.length];
        ps1[0] = nums1[0];
        ps2[0] = nums2[0];
        for(int i = 1; i < nums1.length; i++){
            ps1[i] = ps1[i-1]+nums1[i];
            ps2[i] = ps2[i-1]+nums2[i];
        }
        int ans = Math.max(ps1[ps1.length-1] , ps2[ps2.length-1]);
        for(int l = 1; l < nums1.length; l++){
            for(int i = 0; i+l-1 < nums1.length; i++){
                int ss1 = 0;
                int ss2 = 0;
                if(i != 0){
                    ss1 = ps1[i+l-1]-ps1[i-1];
                    ss2 = ps2[i+l-1]-ps2[i-1];
                }else{
                    ss1 = ps1[i+l-1];
                    ss2 = ps2[i+l-1];
                }
                int s1 = ps1[ps1.length-1]-ss1+ss2;
                int s2 = ps2[ps2.length-1]-ss2+ss1;
                ans = Math.max(ans , Math.max(s1 , s2));
            }
        }
        return ans;*/
        int[] a1 = new int[nums1.length];
        int[] a2 = new int[nums1.length];
        int s1 = 0;
        int s2 = 0;
        for(int i = 0; i < nums1.length; i++){
            a1[i] = nums2[i]-nums1[i];
            a2[i] = nums1[i]-nums2[i];
            s1 += nums1[i];
            s2 += nums2[i];
        }
        int n1 = kadane(a1);
        int n2 = kadane(a2);
        return Math.max(Math.max(s1 , s2) , Math.max(s1+n1 , s2+n2));
    }
}