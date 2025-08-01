class Solution {
    public int findMaxLength(int[] nums) {
        int ps = 0;
        HashMap<Integer , Integer> f = new HashMap<>();
        f.put(0 , -1);
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            /*ps += nums[i];
            if((i+1)%2 == 0){
                int rs = (i+1)/2;
                if(f.containsKey(rs-ps) && rs-ps >= 0)
                ans = Math.max(ans , i-f.get(rs-ps));
                else
            f.put(ps , Math.min(f.getOrDefault(ps , Integer.MAX_VALUE) , i-1));
            }*/
            if(nums[i] == 1)
            ps++;
            else
            ps--;
            if(f.containsKey(ps))
            ans = Math.max(ans , i-f.get(ps));
            else
            f.put(ps , i);
        }
        return ans;
    }
}