class Solution {
    class SegmentTree{
        List<Integer> tree;
        public SegmentTree(){
            tree = new ArrayList<>();
        }
        void insert(int val){
            int s = 0;
            int e = tree.size()-1;
            int index = tree.size();
            while(s <= e){
                int m = s+(e-s)/2;
                if(tree.get(m) < val){
                    s = m+1;
                }else{
                    index = m;
                    e = m-1;
                }
            }
            tree.add(index , val);
        }
        int query(int val){
            int s = 0;
            int e = tree.size()-1;
            int c = -1;
            while(s <= e){
                int m = s+(e-s)/2;
                if(tree.get(m) <= val){
                    c = m;
                    s = m+1;
                }else
                e = m-1;
            }
            return tree.size()-(c+1);
        }
    }
    public long countMajoritySubarrays(int[] nums, int target) {
        int[] a = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target)
            a[i] = 1;
            else
            a[i] = -1;
        }
        int[] ps = new int[nums.length+1];
        for(int i = 1; i < ps.length; i++){
            ps[i] = ps[i-1]+a[i-1];
        }
        SegmentTree st = new SegmentTree();
        long ans = 0;
        for(int i = ps.length-1; i >= 0; i--){
            ans += st.query(ps[i]);
            st.insert(ps[i]);
        }
        return ans;
    }
}