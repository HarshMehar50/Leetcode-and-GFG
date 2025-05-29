class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i] , 0);
        }
        for(int i = 0; i < nums.length; i++){
            int v = map.get(nums[i]);
            map.put(nums[i] , v+1);
        }
        for(Integer x : map.keySet()){
            if(map.get(x) > 1)
            return x;
        }
        return -1;
    }
}