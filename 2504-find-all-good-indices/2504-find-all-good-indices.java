class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int[] p = new int[nums.length];
        int[] s = new int[nums.length];
        Arrays.fill(p , 1);
        Arrays.fill(s , 1);
        for(int i = 1; i < p.length; i++){
            if(nums[i-1] >= nums[i])
            p[i] += p[i-1];
        }
        for(int i = s.length-2; i >= 0; i--){
            if(nums[i] <= nums[i+1])
            s[i] += s[i+1];
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = k; i < nums.length-k; i++){
            if(p[i-1] >= k && s[i+1] >= k)
            ans.add(i);
        }
        return ans;
    }
}