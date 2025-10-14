class Solution {
    final int mod = 1000000007;
    class SegmentTree{
        int[] tree;
        int n;
        public SegmentTree(int n){
            this.n = n;
            tree = new int[4*n];
        }
        void update(int node , int s , int e , int val , int f){
            if(s == e){
                tree[node] = (tree[node]+f)%mod;
                return;
            }
            int m = s+(e-s)/2;
            if(val <= m)
            update(2*node , s , m , val , f);
            else
            update((2*node)+1 , m+1 , e , val , f);
            tree[node] = (tree[2*node]+tree[(2*node)+1])%mod;
        }
        int query(int node , int s , int e , int l , int r){
            if(r < s || e < l)
            return 0;
            if(l <= s && e <= r)
            return tree[node]%mod;
            int m = s+(e-s)/2;
            return (query(2*node , s , m , l , r)+query((2*node)+1 , m+1 , e , l , r))%mod;
        }
    }
    public int createSortedArray(int[] instructions) {
        int ans = 0;
        int max = 0;
        for(int i = 0; i < instructions.length; i++){
            max = Math.max(max , instructions[i]);
        }
        SegmentTree st = new SegmentTree(max+1);
        for(int i = 0; i < instructions.length; i++){
            ans = (ans+Math.min(st.query(1 , 0 , max , 0 , instructions[i]-1) , st.query(1 , 0 , max , instructions[i]+1 , max)))%mod;
            st.update(1 , 0 , max , instructions[i] , 1);
        }
        return ans;
    }
}