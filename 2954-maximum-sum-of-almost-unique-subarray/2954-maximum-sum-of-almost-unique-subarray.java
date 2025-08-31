class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        long s = 0;
        HashMap<Integer , Integer> f = new HashMap<>();
        long ans = 0;
        for(int i = 0; i < k; i++){
            f.put(nums.get(i) , f.getOrDefault(nums.get(i) , 0)+1);
            s += nums.get(i);
        }
        if(f.size() >= m)
        ans = Math.max(ans , s);
        for(int i = k; i < nums.size(); i++){
            f.put(nums.get(i-k) , f.get(nums.get(i-k))-1);
            if(f.get(nums.get(i-k)) == 0)
            f.remove(nums.get(i-k));
            s -= nums.get(i-k);
            s += nums.get(i);
            f.put(nums.get(i) , f.getOrDefault(nums.get(i) , 0)+1);
            if(f.size() >= m)
            ans = Math.max(ans , s);
        }
        return ans;
    }
}