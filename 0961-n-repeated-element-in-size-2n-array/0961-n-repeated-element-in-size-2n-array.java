class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer , Integer> f = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            f.put(nums[i] , f.getOrDefault(nums[i] , 0)+1);
        }
        for(Integer x : f.keySet()){
            if(f.get(x) == nums.length/2)
            return x;
        }
        return -1;
    }
}