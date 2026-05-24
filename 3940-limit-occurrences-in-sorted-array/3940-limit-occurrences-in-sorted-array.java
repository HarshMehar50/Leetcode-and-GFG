class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        List<Integer> l = new ArrayList<>();
        TreeMap<Integer , Integer> f = new TreeMap<>();
        for(int i = 0; i < nums.length; i++){
            f.put(nums[i] , f.getOrDefault(nums[i] , 0)+1);
        }
        for(Integer x : f.keySet()){
            int ff = Math.min(k , f.get(x));
            for(int i = 0; i < ff; i++){
                l.add(x);
            }
        }
        int[] ans = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
}