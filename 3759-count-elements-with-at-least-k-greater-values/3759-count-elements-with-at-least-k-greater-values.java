class Solution {
    public int countElements(int[] nums, int k) {
        TreeMap<Integer , Integer> f = new TreeMap<>();
        for(int i = 0; i < nums.length; i++){
            f.put(nums[i] , f.getOrDefault(nums[i] , 0)+1);
        }
        TreeMap<Integer , Integer> cf = new TreeMap<>();
        cf.put(0 , 0);
        for(Integer x : f.keySet()){
            int lv = cf.get(cf.lastKey());
            cf.put(x , lv+f.get(x));
        }
        int ans = 0;
        for(Integer x : f.keySet()){
            if(nums.length-cf.get(x) >= k)
            ans += f.get(x); 
        }
        return ans;
    }
}