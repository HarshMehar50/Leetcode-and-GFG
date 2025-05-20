class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int mask = 0; mask < (1<<9); mask++){
            if(Integer.bitCount(mask) == k){
                int s = 0;
                for(int i = 0; i < 9; i++){
                    if((mask&(1<<i)) != 0)
                    s += i+1;
                }
                if(s == n){
                    List<Integer> inner = new ArrayList<>();
                    for(int i = 0; i < 9; i++){
                        if((mask&(1<<i)) != 0)
                        inner.add(i+1);
                    }
                    ans.add(inner);
                }
            }
        }
        return ans;
    }
}