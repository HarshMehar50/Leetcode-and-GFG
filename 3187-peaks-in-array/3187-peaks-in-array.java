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

    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int[] a = new int[nums.length];
        for(int i = 1; i < nums.length-1; i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
            a[i] = 1;
        }
        SegmentTree st = new SegmentTree(a);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            if(queries[i][0] == 1)
            ans.add(st.query(queries[i][1]+1 , queries[i][2]-1));
            else{
                nums[queries[i][1]] = queries[i][2];
                boolean lgi = false;
                if(queries[i][1]-1 >= 0 && nums[queries[i][1]] > nums[queries[i][1]-1])
                lgi = true;
                boolean rgi = false;
                if(queries[i][1]+1 < nums.length && nums[queries[i][1]] > nums[queries[i][1]+1])
                rgi = true;
                /*if(rg && lg){
                    if(a[queries[i][1]] != 1){
                        st.update(queries[i][1] , 1);
                        a[queries[i][1]] = 1;
                        if(a[queries[i][1]+1] != 0){
                            st.update(queries[i][1]+1 , 0);
                            a[queries[i][1]+1] = 0;
                        }
                        if(a[queries[i][1]-1] != 0){
                            st.update(queries[i][1]-1 , 0);
                            a[queries[i][1]-1] = 0;
                        }
                    }
                }else{
                    if(a[queries[i][1]] != 0){
                        st.update(queries[i][1] , 0);
                        a[queries[i][1]] = 0;
                    }
                    if(queries[i][1]-2 >= 0 && nums[queries[i][1]-1] > nums[queries[i][1]-2]){
                        st.update(queries[i][1]-1 , 1);
                        a[queries[i][1]-1] = 1;
                    }
                    if(queries[i][1]+2 < a.length && nums[queries[i][1]+1] > nums[queries[i][1]+2]){
                        st.update(queries[i][1]+1 , 1);
                        a[queries[i][1]+1] = 1;
                    }
                }*/

                if(lgi && rgi){
                    if(a[queries[i][1]] != 1){
                        st.update(queries[i][1] , 1);
                        a[queries[i][1]] = 1;
                    }
                }else{
                    if(a[queries[i][1]] != 0){
                        st.update(queries[i][1] , 0);
                        a[queries[i][1]] = 0;
                    }
                }

                boolean lgip = false;
                boolean rgip = false;
                if(queries[i][1]+2 < nums.length && nums[queries[i][1]+1] > nums[queries[i][1]+2])
                rgip = true;
                if(queries[i][1]+1 < nums.length && nums[queries[i][1]+1] > nums[queries[i][1]])
                lgip = true;
                int uvp = 0;
                if(rgip && lgip)
                uvp = 1;
                if(queries[i][1]+1 < a.length && a[queries[i][1]+1] != uvp){
                    st.update(queries[i][1]+1 , uvp);
                    a[queries[i][1]+1] = uvp;
                }

                boolean lgim = false;
                boolean rgim = false;
                if(queries[i][1]-2 >= 0 && nums[queries[i][1]-1] > nums[queries[i][1]-2])
                lgim = true;
                if(queries[i][1]-1 >= 0 && nums[queries[i][1]-1] > nums[queries[i][1]])
                rgim = true;
                int uvm = 0;
                if(rgim && lgim)
                uvm = 1;
                if(queries[i][1]-1 >= 0 && a[queries[i][1]-1] != uvm){
                    st.update(queries[i][1]-1 , uvm);
                    a[queries[i][1]-1] = uvm;
                }
            }
        }
        return ans;
    }
}