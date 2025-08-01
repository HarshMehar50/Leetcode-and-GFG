class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int ps = 0;
        HashMap<Integer , Integer> f = new HashMap<>();
        f.put(0 , -1);
        for(int i = 0; i < nums.length; i++){
            ps += nums[i];
            /*int l = f.getOrDefault(ps%k , Integer.MAX_VALUE);
            if(l != Integer.MAX_VALUE)
            if(i-l+1 >= 2)
            return true;
            f.put(ps%k , Math.min(f.getOrDefault(ps%k , Integer.MAX_VALUE) , i));*/
            if(f.containsKey(ps%k)){
            if(i-f.get(ps%k) >= 2)
            return true;
            }else
            f.put(ps%k , i);
        }
        return false;
    }
}