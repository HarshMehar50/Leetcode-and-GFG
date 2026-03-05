class Solution {
    int pcd(long n){
        int ans = 0;
        while(n != 1){
            n = Long.bitCount(n);
            ans++;
        }
        return ans;
    }
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
    public int[] popcountDepth(long[] nums, long[][] queries) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            int p = pcd(nums[i]);
            max = Math.max(max , p);
        }
        for(long[] q : queries){
            if(q[0] == 2)
            max = Math.max(max , pcd(q[2]));
        }
        int[][] f = new int[max+1][nums.length];
        for(int i = 0; i < nums.length; i++){
            f[pcd(nums[i])][i]++;
        }
        SegmentTree[] st = new SegmentTree[max+1];
        for(int i = 0; i <= max; i++){
            st[i] = new SegmentTree(f[i]);
        }
        List<Integer> l = new ArrayList<>();
        for(long[] q : queries){
            if(q[0] == 2){
                int i = (int)q[1];
                long nv = q[2];
                long pv = nums[i];
                int pn = pcd(nv);
                int pp = pcd(pv);
                nums[i] = nv;
                f[pp][i]--;
                f[pn][i]++;
                st[pp].update(i , f[pp][i]);
                st[pn].update(i , f[pn][i]);
            }else{
                if(q[3] <= max)
                l.add(st[(int)q[3]].query((int)q[1] , (int)q[2]));
                else
                l.add(0);
            }
        }
        int[] ans = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
}