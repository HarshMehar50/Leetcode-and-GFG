class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> l = new ArrayList<>();
        for(int i = nums.length-1; i >= 0; i--){
            if(l.size() == k) continue;
            if(!l.contains(nums[i]))
                l.add(nums[i]);
        }
        int[] ans = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
}