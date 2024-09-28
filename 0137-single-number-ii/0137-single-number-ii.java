class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i] , 0);
        }
        for(int i = 0; i < nums.length; i++){
            int x = map.get(nums[i])+1;
            map.put(nums[i] , x);
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == 1){
            ans = nums[i];
            break;
            }
        }
        return ans;
    }
}