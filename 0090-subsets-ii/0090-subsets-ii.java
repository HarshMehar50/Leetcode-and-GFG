class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int mask = 0; mask < (1<<nums.length); mask++){
            List<Integer> inner = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                if((mask&(1<<i)) != 0)
                inner.add(nums[i]);
            }
            if(!ans.contains(inner))
            ans.add(inner);
        }
        return ans;
    }
}