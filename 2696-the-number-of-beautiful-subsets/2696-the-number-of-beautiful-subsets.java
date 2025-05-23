class Solution {
    boolean check(List<Integer> list , int k){
        for(int i = 0; i < list.size()-1; i++){
            for(int j = i+1; j < list.size(); j++){
                if(list.get(j)-list.get(i) == k)
                return false;
            }
        }
        return true;
    }
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for(int mask = 1; mask < (1<<nums.length); mask++){
            List<Integer> inner = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                if((mask&(1<<i)) != 0)
                inner.add(nums[i]);
            }
            if(check(inner , k))
            ans++;
        }
        return ans;
    }
}