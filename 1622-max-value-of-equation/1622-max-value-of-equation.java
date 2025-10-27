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
                tree[node] = Math.max(tree[2 * node + 1] , tree[2 * node + 2]);
            }
        }

        int query(int node, int l, int r, int ql, int qr) {
            if (qr < l || ql > r) return Integer.MIN_VALUE;
            if (ql <= l && r <= qr) return tree[node];
            int mid = (l + r) / 2;
            int left = query(2 * node + 1, l, mid, ql, qr);
            int right = query(2 * node + 2, mid + 1, r, ql, qr);
            return Math.max(left , right);
        }

        int query(int l, int r) {
            return query(0, 0, n - 1, l, r);
        }
    }
    int floor(int[][] a , int x){
        int s = 0;
        int e = a.length-1;
        int f = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(a[m][0] <= x){
                f = m;
                s = m+1;
            }else
            e = m-1;
        }
        return f;
    }
    public int findMaxValueOfEquation(int[][] points, int k) {
        int[] a = new int[points.length];
        for(int i = 0; i < points.length; i++){
            a[i] = points[i][0]+points[i][1];
        }
        SegmentTree st = new SegmentTree(a);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < a.length-1; i++){
            int j = floor(points , points[i][0]+k);
            ans = Math.max(ans , points[i][1]-points[i][0]+st.query(i+1 , j));
        }
        return ans;
    }
}