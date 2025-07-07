class Solution {
    void solve(int[] candidates , int target , int i , int sum , List<List<Integer>> ans , List<Integer> inner){
        if(sum == target){
            ans.add(new ArrayList<>(inner));
            return;
        }
        if(i == candidates.length || sum > target)
        return;
        if(sum+candidates[i] <= target){
            //sum += candidates[i];
            inner.add(candidates[i]);
            solve(candidates , target , i , sum+candidates[i] , ans , inner);
            inner.remove(inner.size()-1);
        }
        solve(candidates , target , i+1 , sum , ans , inner);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        solve(candidates , target , 0 , 0 , ans , inner);
        return ans;
    }
}