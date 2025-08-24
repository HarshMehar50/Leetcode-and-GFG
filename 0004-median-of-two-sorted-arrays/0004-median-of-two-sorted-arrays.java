class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*int max = 0;
        if(nums1.length != 0)
        max = Math.max(nums1[nums1.length-1] , max);
        if(nums2.length != 0)
        max = Math.max(nums2[nums2.length-1] , max);
        int min = Integer.MAX_VALUE;
        if(nums1.length != 0)
        min = Math.min(nums1[0] , min);
        if(nums2.length != 0)
        min = Math.min(nums2[0] , min);
        double s = min;
        double e = max;
        int iterations = (int)(Math.log((e-s)*10)/Math.log(2))+2;
        for(int j = 0; j < iterations; j++){
            double m = s+(e-s)/2;
            if((nums1.length+nums2.length)%2 == 1){
                int c1 = 0;
                int c2 = 0;
                for(int i = 0; i < nums1.length; i++){
                    if(nums1[i] < (int)m)
                    c1++;
                }
                for(int i = 0; i < nums2.length; i++){
                    if(nums2[i] < (int)m)
                    c2++;
                }
                if(c1+c2 == (nums1.length+nums2.length)/2)
                return m;
                else if(c1+c2 > (nums1.length+nums2.length)/2)
                e = m-0.1;
                else
                s = m+0.1;
            }else{
                int c1 = 0;
                int c2 = 0;
                for(int i = 0; i < nums1.length; i++){
                    if(nums1[i] <= (int)m)
                    c1++;
                }
                for(int i = 0; i < nums2.length; i++){
                    if(nums2[i] <= (int)m)
                    c2++;
                }
                if(c1+c2 == (nums1.length+nums2.length)/2)
                return m;
                else if(c1+c2 > (nums1.length+nums2.length)/2)
                e = m-0.1;
                else
                s = m+0.1;
            }
        }
        if(nums1.length == 0)
        return nums2[0];
        else if(nums2.length == 0)
        return nums1[0];
        else
        return (nums1[0]+nums2[0])/2;*/
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2)
        return findMedianSortedArrays(nums2 , nums1);
        int l = (n1+n2+1)/2;
        int s = 0;
        int e = n1;
        while(s <= e){
            int m1 = s+(e-s)/2;
            int m2 = l-m1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE; 
            if(m1 > 0)
            l1 = nums1[m1-1];
            if(m2 > 0)
            l2 = nums2[m2-1];
            if(m1 < n1)
            r1 = nums1[m1];
            if(m2 < n2)
            r2 = nums2[m2];
            if(l1 <= r2 && l2 <= r1){
                if((n1+n2)%2 == 1)
                return Math.max(l1 , l2);
                else
                return (double)((Math.max(l1 , l2)+Math.min(r1 , r2))/2.0);
            }else if(l1 > r2)
            e = m1-1;
            else
            s = m1+1;
        }
        return -1;
    }
}