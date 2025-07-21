class Solution {
    void solve(int[] nums , List<List<Integer>> ans , List<Integer> inner , boolean[] visited){
        if(inner.size() == nums.length){
            ans.add(new ArrayList<>(inner));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                inner.add(nums[i]);
                solve(nums , ans , inner , visited);
                inner.remove(inner.size()-1);
                visited[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        solve(nums , ans , inner , visited);
        return ans;
    }
}