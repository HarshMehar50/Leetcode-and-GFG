// User function Template for Java

class Solution {
    int gcd(int a , int b){
        if(b == 0)
        return Math.abs(a);
        return gcd(b , a%b);
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
                tree[node] = gcd(tree[2 * node + 1] , tree[2 * node + 2]);
            }
        }

        int query(int node, int l, int r, int ql, int qr) {
            if (qr < l || ql > r) return 0;
            if (ql <= l && r <= qr) return tree[node];
            int mid = (l + r) / 2;
            int left = query(2 * node + 1, l, mid, ql, qr);
            int right = query(2 * node + 2, mid + 1, r, ql, qr);
            return gcd(left , right);
        }

        int query(int l, int r) {
            return query(0, 0, n - 1, l, r);
        }
    }
    int findSmallestSubArr(int[] arr, int k) {
        // code here
        SegmentTree st = new SegmentTree(arr);
        int ans = arr.length+1;
        for(int l = 0; l < arr.length; l++){
            int sr = l;
            int er = arr.length-1;
            int r = -1;
            while(sr <= er){
                int mr = sr+(er-sr)/2;
                int g = st.query(l , mr);
                if(g == k){
                    r = mr;
                    er = mr-1;
                }else if(g > k)
                sr = mr+1;
                else
                er = mr-1;
            }
            if(r != -1)
            ans = Math.min(ans , r-l+1);
        }
        if(ans == arr.length+1)
        return -1;
        return ans;
    }
}
