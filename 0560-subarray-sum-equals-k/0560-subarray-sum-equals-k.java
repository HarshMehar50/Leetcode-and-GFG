class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] ps = new int[nums.length];
        ps[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            ps[i] = ps[i-1]+nums[i];
        }
        /*HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(ps[i] , Math.min(map.getOrDefault(ps[i] , Integer.MAX_VALUE) , i));
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(ps[i] == k)
            ans++;
            else if(ps[i] > k){
                if(map.containsKey(ps[i]-k) && map.get(ps[i]-k) < i)
                ans++;
            }else{
                if(map.containsKey(k-ps[i]) && map.get(k-ps[i]) > i)
                ans++;
            }
        }*/
        int ans = 0;
        /*for(int l = 1; l <= nums.length; l++){
            for(int i = 0; i+l-1 < nums.length; i++){
                int ss = 0;
                if(i == 0)
                ss = ps[i+l-1];
                else
                ss = ps[i+l-1]-ps[i-1];
                if(ss == k)
                ans++;
            }
        }*/
        HashMap<Integer , Integer> map = new HashMap<>();
        int s = 0;
        map.put(0 , 1);
        for(int i = 0; i < nums.length; i++){
            s += nums[i];
            ans += map.getOrDefault(s-k , 0);
            map.put(s , map.getOrDefault(s , 0)+1);
        }
        return ans;
    }
}