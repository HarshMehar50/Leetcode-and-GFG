class Solution {
    void solve(int[] candidates , int target , int i , List<Integer> inner , List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(inner));
            return;
        }
        if(i >= candidates.length)
        return;
        /*if(target-candidates[i] >= 0){
            inner.add(candidates[i]);
            solve(candidates , target-candidates[i] , i+1 , inner , ans);
            inner.remove(inner.size()-1);
        }
        solve(candidates , target , i+1 , inner , ans);*/
        for(int j = i; j < candidates.length; j++){
            if(j > i && candidates[j] == candidates[j-1]) continue;
            if(candidates[j] > target) break;
            inner.add(candidates[j]);
            solve(candidates , target-candidates[j] , j+1 , inner , ans);
            inner.remove(inner.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        solve(candidates , target , 0 , inner , ans);
        return ans;
    }
}