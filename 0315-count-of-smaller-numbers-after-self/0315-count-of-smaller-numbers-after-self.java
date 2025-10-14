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
    public List<Integer> countSmaller(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max , nums[i]+10000);
        }
        SegmentTree st = new SegmentTree(max+1);
        st.update(1 , 0 , max , nums[nums.length-1]+10000 , 1);
        int[] a = new int[nums.length];
        for(int i = a.length-2; i >= 0; i--){
            a[i] = st.query(1 , 0 , max , 0 , nums[i]-1+10000);
            st.update(1 , 0 , max , nums[i]+10000 , 1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            ans.add(a[i]);
        }
        return ans;
    }
}