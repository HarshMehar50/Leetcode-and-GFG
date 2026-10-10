class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long t = k1+k2;
        long s = 0;
        for(int i = 0; i < nums1.length; i++){
            nums1[i] = Math.abs(nums1[i]-nums2[i]);
            s += nums1[i];
        }
        if(s <= t)
        return 0;
        Arrays.sort(nums1);
        int[] d = new int[nums1.length+1];
        for(int i = 0; i < nums1.length; i++){
            d[i] = nums1[nums1.length-1-i];
        }
        for(int i = 1; i <= nums1.length; i++){
            long cost = (long)((long)(d[i-1]-d[i])*(long)i);
            if(cost > t){
                long q = t/i;
                long r = t%i;
                long h = d[i-1]-q;
                long ans = h*h*(i-r) + (h-1)*(h-1)*r;
                for(int j = i; j < nums1.length;j++){
                    ans += (long)d[j]*(long)d[j];
                }
                return ans;
            }
            t -= cost;
        }
        return 0;
    }
}