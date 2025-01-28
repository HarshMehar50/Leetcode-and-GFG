class Solution {
    public void moveZeroes(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0)
            l.add(nums[i]);
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
            l.add(nums[i]);
        }
        for(int i = 0; i < nums.length; i++){
            nums[i]= l.get(i);
        }
    }
}