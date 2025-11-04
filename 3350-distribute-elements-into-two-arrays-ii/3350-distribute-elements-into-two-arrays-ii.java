class Solution {
    class SegmentTree{
        List<int[]> tree;
        public SegmentTree(){
            tree = new ArrayList<>();
        }
        void insert(int val , int i){
            int s = 0;
            int e = tree.size()-1;
            int index = tree.size();
            while(s <= e){
                int m = s+(e-s)/2;
                if(tree.get(m)[0] < val){
                    s = m+1;
                }else{
                    index = m;
                    e = m-1;
                }
            }
            tree.add(index , new int[]{val , i});
        } 
        /*int query(int val){
            int s = 0;
            int e = tree.size()-1;
            int c = -1;
            while(s <= e){
                int m = s+(e-s)/2;
                if(tree.get(m)[0] <= val){
                    c = m;
                    s = m+1;
                }else
                e = m-1;
            }
            return c+1;
        }*/
        int query(int x){
            int s = 0;
            int e = tree.size()-1;
            int f = -1;
            while(s <= e){
                int m = s+(e-s)/2;
                if(tree.get(m)[0] <= x){
                    f = m;
                    s = m+1;
                }else
                e = m-1;
            }
            return tree.size()-1-f;
        }
    }
    public int[] resultArray(int[] nums) {
        SegmentTree st1 = new SegmentTree();
        SegmentTree st2 = new SegmentTree();
        st1.insert(nums[0] , 0);
        st2.insert(nums[1] , 1);
        for(int i = 2; i < nums.length; i++){
            int gc1 = st1.query(nums[i]);
            int gc2 = st2.query(nums[i]);
            if(gc1 > gc2)
            st1.insert(nums[i] , i);
            else if(gc2 > gc1)
            st2.insert(nums[i] , i);
            else{
                if(st1.tree.size() <= st2.tree.size())
                st1.insert(nums[i] , i);
                else
                st2.insert(nums[i] , i);
            }
        }
        List<int[]> l1 = st1.tree;
        List<int[]> l2 = st2.tree;
        Collections.sort(l1 , (x , y)->Integer.compare(x[1] , y[1]));
        Collections.sort(l2 , (x , y)->Integer.compare(x[1] , y[1]));
        int i = 0;
        int[] ans = new int[nums.length];
        for(int j = 0; j < l1.size(); j++){
            ans[i] = l1.get(j)[0];
            i++;
        }
        for(int j = 0; j < l2.size(); j++){
            ans[i] = l2.get(j)[0];
            i++;
        }
        return ans;
    }
}