class Solution {
    class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(arr, 0, 0, n - 1);
        }

        void build(int[] arr, int node, int l, int r) {
            if (l == r) {
                tree[node] = arr[l];
            } else {
                int mid = (l + r) / 2;
                build(arr, 2 * node + 1, l, mid);
                build(arr, 2 * node + 2, mid + 1, r);
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        int query(int node, int l, int r, int ql, int qr) {
            if (qr < l || ql > r) return 0;
            if (ql <= l && r <= qr) return tree[node];
            int mid = (l + r) / 2;
            int left = query(2 * node + 1, l, mid, ql, qr);
            int right = query(2 * node + 2, mid + 1, r, ql, qr);
            return left + right;
        }

        void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val;
            } else {
                int mid = (l + r) / 2;
                if (idx <= mid)
                    update(2 * node + 1, l, mid, idx, val);
                else
                    update(2 * node + 2, mid + 1, r, idx, val);
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        int query(int l, int r) {
            return query(0, 0, n - 1, l, r);
        }

        void update(int idx, int val) {
            update(0, 0, n - 1, idx, val);
        }
    }
    public int[] minDeletions(String s, int[][] queries) {
        /*int[] a = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'A')
            a[i] = 1;
            else
            a[i] = -1;
        }
        SegmentTree st = new SegmentTree(a);
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            if(queries[i][0] == 2){
                int s1 = st.query(queries[i][1] , queries[i][2]);
                l.add(Math.min(Math.abs(s1+1) , Math.min(Math.abs(s1) , Math.abs(s1-1))));
            }else{
                if(a[queries[i][1]] == 1){
                    st.update(queries[i][1] , -1);
                    a[queries[i][1]] = -1;
                }else{
                    st.update(queries[i][1] , 1);
                    a[queries[i][1]] = 1;
                }
            }
        }
        int[] ans = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            ans[i] = l.get(i);
        }
        return ans;*/
        int[] a = new int[s.length()];
        for(int i = 1; i < a.length; i++){
            if(s.charAt(i) == s.charAt(i-1))
            a[i] = 1;
        }
        StringBuilder sb = new StringBuilder(s);
        SegmentTree st = new SegmentTree(a);
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            if(queries[i][0] == 2)
            l.add(st.query(queries[i][1]+1 , queries[i][2]));
            else{
                int j = queries[i][1];
                if(sb.charAt(j) == 'A')
                sb.setCharAt(j , 'B');
                else
                sb.setCharAt(j , 'A');
                
                if(j-1 >= 0){
                    if(sb.charAt(j-1) == sb.charAt(j)){
                        st.update(j , 1);
                    }else{
                        st.update(j , 0);
                    }
                }

                if(j+1 < sb.length()){
                    if(sb.charAt(j) == sb.charAt(j+1)){
                        st.update(j+1 , 1);
                    }else{
                        st.update(j+1 , 0);
                    }
                }
            }
        }
        int[] ans = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
}