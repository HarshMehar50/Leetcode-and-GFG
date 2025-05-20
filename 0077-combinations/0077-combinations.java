class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int mask = 0; mask < (1<<n); mask++){
            if(Integer.bitCount(mask) == k){
                List<Integer> inner = new ArrayList<>();
                for(int i = 0; i < n; i++){
                    if((mask&(1<<i)) != 0)
                    inner.add(i+1);
                }
                ans.add(inner);
            }
        }
        return ans;
    }
}