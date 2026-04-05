class Solution {
    public List<Integer> findGoodIntegers(int n) {
        Set<Integer> once = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i*i*i <= n; i++){
            for(int j = i; j*j*j <= n; j++){
                if((i*i*i)+(j*j*j) <= n){
                if(once.contains((i*i*i)+(j*j*j)))
                    set.add((i*i*i)+(j*j*j));
                }
                once.add((i*i*i)+(j*j*j));
            }
        }
        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
}