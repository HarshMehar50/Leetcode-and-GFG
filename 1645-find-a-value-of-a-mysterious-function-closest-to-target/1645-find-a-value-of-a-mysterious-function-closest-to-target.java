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
                tree[node] = tree[2 * node + 1]&tree[2 * node + 2];
            }
        }

        int query(int node, int l, int r, int ql, int qr) {
            if (qr < l || ql > r) return ~0;
            if (ql <= l && r <= qr) return tree[node];
            int mid = (l + r) / 2;
            int left = query(2 * node + 1, l, mid, ql, qr);
            int right = query(2 * node + 2, mid + 1, r, ql, qr);
            return left&right;
        }

        int query(int l, int r) {
            return query(0, 0, n - 1, l, r);
        }
    }
    public int closestToTarget(int[] arr, int target) {
        SegmentTree st = new SegmentTree(arr);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            int s = i;
            int e = arr.length-1;
            while(s <= e){
                int m = s+(e-s)/2;
                int suband = st.query(i , m);
                if(suband >= target){
                    ans = Math.min(ans , Math.abs(target-suband)); 
                    s = m+1;
                }else
                e = m-1;
            }
            s = i;
            e = arr.length-1;
            while(s <= e){
                int m = s+(e-s)/2;
                int suband = st.query(i , m);
                if(suband <= target){
                    ans = Math.min(ans , Math.abs(suband-target));
                    e = m-1;
                }else
                s = m+1;
            }
        }
        return ans;
    }
}