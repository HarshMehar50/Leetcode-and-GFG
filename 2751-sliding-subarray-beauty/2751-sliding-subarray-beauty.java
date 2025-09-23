class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        TreeMap<Integer , Integer> map = new TreeMap<>();
        for(int i = 0; i < k; i++){
            if(nums[i] < 0)
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
        }
        int[] ans = new int[nums.length-k+1];
        int c = 0;
        for(Integer y : map.keySet()){
            c += map.get(y);
            if(c >= x){
                ans[0] = y;
                break;
            }
        }
        for(int i = k; i < nums.length; i++){
            c = 0;
            if(nums[i-k] < 0){
                map.put(nums[i-k] , map.get(nums[i-k])-1);
                if(map.get(nums[i-k]) == 0)
                map.remove(nums[i-k]);
            }
            if(nums[i] < 0)
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
            for(Integer y : map.keySet()){
                c += map.get(y);
                if(c >= x){
                    ans[i-k+1] = y;
                    break;
                }
            }
        }
        return ans;
    }
}