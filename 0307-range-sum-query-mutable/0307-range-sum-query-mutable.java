class NumArray {
    int[] st;
    int n;
    void build(int[] nums , int i , int l , int r){
        if(l == r)
        st[i] = nums[l];
        else{
            int m = l+(r-l)/2;
            build(nums , (2*i)+1 , l , m);
            build(nums , (2*i)+2 , m+1 , r);
            st[i] = st[(2*i)+1]+st[(2*i)+2];
        }
    }
    public NumArray(int[] nums) {
        n = nums.length;
        st = new int[4*n];
        build(nums , 0 , 0 , n-1);
    }
    
    void solveUpdate(int i , int l , int r , int index , int val){
        if(l == r)
        st[i] = val;
        else{
            int m = l+(r-l)/2;
            if(index <= m)
            solveUpdate((2*i)+1 , l , m , index , val);
            else
            solveUpdate((2*i)+2 , m+1 , r , index , val);
            st[i] = st[(2*i)+1]+st[(2*i)+2];
        }
    }
    public void update(int index, int val) {
        solveUpdate(0 , 0 , n-1 , index , val);
    }
    
    int solveQuery(int i , int l , int r , int ql , int qr){
        if(qr < l || ql > r)
        return 0;
        if(ql <= l && r <= qr)
        return st[i];
        int m = l+(r-l)/2;
        int left = solveQuery((2*i)+1 , l , m , ql , qr);
        int right = solveQuery((2*i)+2 , m+1 , r , ql , qr);
        return left+right;
    }
    public int sumRange(int left, int right) {
        return solveQuery(0 , 0 , n-1 , left , right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */