class Solution {
    class SegmentTree{
        List<Long> tree;
        public SegmentTree(){
            tree = new ArrayList<>();
        }
        void insert(long val){
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
        int query(long val){
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
            return c+1;
        }
    }
    public int countRevPairs(int[] nums) {
        // code here
        SegmentTree st = new SegmentTree();
        int ans = 0;
        for(int i = nums.length-1; i >= 0; i--){
            ans += st.query((long)((long)nums[i]-1L));
            st.insert((long)((long)2*(long)nums[i]));
        }
        return ans;
    }
}