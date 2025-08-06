class RangeFreqQuery {
    HashMap<Integer , Integer>[] fst;
    int n;
    void build(int[] arr , int i , int l , int r){
        if(l == r)
        fst[i].put(arr[l] , fst[i].getOrDefault(arr[l] , 0)+1);
        else{
            int m = l+(r-l)/2;
            build(arr , (2*i)+1 , l , m);
            build(arr , (2*i)+2 , m+1 , r);
            for(Integer x : fst[(2*i)+1].keySet()){
                fst[i].put(x , fst[i].getOrDefault(x , 0)+fst[(2*i)+1].get(x));
            }
            for(Integer x : fst[(2*i)+2].keySet()){
                fst[i].put(x , fst[i].getOrDefault(x , 0)+fst[(2*i)+2].get(x));
            }
        }
    }
    public RangeFreqQuery(int[] arr) {
        n = arr.length;
        fst = new HashMap[4*n];
        for (int i = 0; i < fst.length; i++){
            fst[i] = new HashMap<>();
        }
        build(arr , 0 , 0 , n-1);
    }
    
    int solve(int i , int l , int r , int ql , int qr , int value){
        if(r < ql || l > qr)
        return 0;
        if(r <= qr && l >= ql)
        return fst[i].getOrDefault(value , 0);
        int m = l+(r-l)/2;
        int left = solve((2*i)+1 , l , m , ql , qr , value);
        int right = solve((2*i)+2 , m+1 , r , ql , qr , value);
        return left+right;
    }
    public int query(int left, int right, int value) {
        return solve(0 , 0 , n-1 , left , right , value);
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */