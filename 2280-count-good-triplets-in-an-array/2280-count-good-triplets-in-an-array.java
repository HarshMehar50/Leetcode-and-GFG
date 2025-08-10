class Solution {
    long[] st;
    int n;
    void update(int i , int l , int r , int index){
        if(l == r){
            st[i] = 1;
            return;
        }
        int m = l+(r-l)/2;
        if(index <= m)
        update((2*i)+1 , l , m , index);
        else
        update((2*i)+2 , m+1 , r , index);
        st[i] = st[(2*i)+1]+st[(2*i)+2];
    }
    long query(int i , int l , int r , int ql , int qr){
        if(qr < l || ql > r)
        return 0;
        if(ql <= l && r <= qr)
        return st[i];
        int m = l+(r-l)/2;
        long left = query((2*i)+1 , l , m , ql , qr);
        long right = query((2*i)+2 , m+1 , r , ql , qr);
        return left+right;
    }
    public long goodTriplets(int[] nums1, int[] nums2) {
        long ans = 0;
        n = nums1.length;
        st = new long[4*n];
        int[][] a = new int[n][2];
        for(int i = 0; i < n; i++){
            a[nums1[i]][0] = i;
            a[nums2[i]][1] = i;
        }
        update(0 , 0 , n-1 , a[nums1[0]][1]);
        for(int i = 1; i < n; i++){
            long leftCommon = query(0 , 0 , n-1 , 0 , a[nums1[i]][1]);
            long leftUncommon = i-leftCommon;
            long rightnums2 = n-1-a[nums1[i]][1];
            long rightCommon = rightnums2-leftUncommon;
            ans += leftCommon*rightCommon;
            update(0 , 0 , n-1 , a[nums1[i]][1]);
        }
        return ans;
    }
}