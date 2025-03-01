class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                nums[i] = 2*nums[i];
                nums[i+1] = 0;
            }
        }
        List<Integer> ansList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0)
            ansList.add(nums[i]);
        }
        int[] ans = new int[nums.length];
        for(int i = 0; i < ansList.size(); i++){
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}