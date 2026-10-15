class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = nums.size();
        for(int l = 2; l <= nums.size(); l++){
            HashMap<Integer , Integer> f = new HashMap<>();
            for(int i = 0; i < l; i++){
                f.put(nums.get(i) , f.getOrDefault(nums.get(i) , 0)+1);
            }
            ans += f.size()*f.size();
            for(int i = l; i < nums.size(); i++){
                f.put(nums.get(i-l) , f.get(nums.get(i-l))-1);
                if(f.get(nums.get(i-l)) == 0)
                f.remove(nums.get(i-l));
                f.put(nums.get(i) , f.getOrDefault(nums.get(i) , 0)+1);
                ans += f.size()*f.size();
            }
        }
        return ans;
    }
}