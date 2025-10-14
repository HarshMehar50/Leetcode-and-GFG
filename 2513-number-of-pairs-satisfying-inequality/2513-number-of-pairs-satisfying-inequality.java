class Solution {
    class SegmentTree{
        int[] tree;
        int n;
        public SegmentTree(int n){
            this.n = n;
            tree = new int[4*n];
        }
        void update(int node , int s , int e , int val , int f){
            if(s == e){
                tree[node] += f;
                return;
            }
            int m = s+(e-s)/2;
            if(val <= m)
            update(2*node , s , m , val , f);
            else
            update((2*node)+1 , m+1 , e , val , f);
            tree[node] = tree[2*node]+tree[(2*node)+1];
        }
        int query(int node , int s , int e , int l , int r){
            if(r < s || e < l)
            return 0;
            if(l <= s && e <= r)
            return tree[node];
            int m = s+(e-s)/2;
            return query(2*node , s , m , l , r)+query((2*node)+1 , m+1 , e , l , r);
        }
    }
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int[] a = new int[nums1.length];
        int max = 0;
        for(int i = 0; i < a.length; i++){
            a[i] = nums1[i]-nums2[i];
            max = Math.max(max , a[i]+20000);
        }
        SegmentTree st = new SegmentTree(max);
        st.update(1 , 0 , max , a[a.length-1]+20000 , 1);
        long ans = 0;
        for(int i = a.length-2; i >= 0; i--){
            ans += st.query(1 , 0 , max , a[i]+20000-diff , max);
            st.update(1 , 0 , max , a[i]+20000 , 1);
        }
        return ans;
    }
}