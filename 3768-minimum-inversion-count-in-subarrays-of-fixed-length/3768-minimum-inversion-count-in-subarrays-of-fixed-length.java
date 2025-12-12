class Solution {
    /*int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || sorted[i] != sorted[i-1])
            sorted[j++] = sorted[i];
        }
        HashMap<Integer , Integer> compressed = new HashMap<>();
        for(int i = 0; i < j; i++){
            compressed.put(sorted[i] , i+1);
        }
        int[] ca = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ca[i] = compressed.get(nums[i]);
        }*/
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
        int querye(int val){
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
        int query(int val){
            int s = 0;
            int e = tree.size()-1;
            int c = -1;
            while(s <= e){
                int m = s+(e-s)/2;
                if(tree.get(m) < val){
                    c = m;
                    s = m+1;
                }else
                e = m-1;
            }
            return c+1;
        }
        void delete(int x){
            int index = Collections.binarySearch(tree , x);
            tree.remove(index);
        }
        int size(){
            return tree.size();
        }
    }
    public long minInversionCount(int[] nums, int k) {
        SegmentTree st = new SegmentTree();
        long ws = 0;
        long ans = (long)(1e12);
        for(int i = nums.length-1; i >= nums.length-k; i--){
            ws += st.query(nums[i]);
            st.insert(nums[i]);
        }
        ans = Math.min(ans , ws);
        for(int i = nums.length-k-1; i >= 0; i--){
            /*st.delete(nums[i+k]);
            int remove = st.query(nums[i+k]);
            ws -= remove;
            ws += st.query(nums[i]);
            ans = Math.min(ans , ws);
            st.insert(nums[i]);*/
            int remove = st.size()-st.querye(nums[i+k]);
            ws -= remove;
            st.delete(nums[i+k]);
            ws += st.query(nums[i]);
            st.insert(nums[i]);
            ans = Math.min(ans , ws);
        }
        return ans;
    }
}