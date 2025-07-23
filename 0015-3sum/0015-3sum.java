class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int t = -nums[i];
            for(int j = i+1; j < nums.length; j++){
                int nt = t-nums[j];
                int bs = Arrays.binarySearch(nums , nt);
                if(bs < nums.length && bs >= 0 && bs != i && bs != j){
                    List<Integer> inner = new ArrayList<>();
                    inner.add(nums[i]);
                    inner.add(nums[j]);
                    inner.add(nums[bs]);
                    Collections.sort(inner);
                    set.add(inner);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}