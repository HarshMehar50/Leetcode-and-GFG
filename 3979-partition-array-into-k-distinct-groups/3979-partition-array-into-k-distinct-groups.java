class Solution {
    public boolean partitionArray(int[] nums, int k) {
        if(nums.length%k != 0)
        return false;
        HashMap<Integer , Integer> f = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            f.put(nums[i] , f.getOrDefault(nums[i] , 0)+1);
        }
        for(Integer x : f.keySet()){
            if(f.get(x) > nums.length/k)
            return false;
        }
        return true;
    }
}