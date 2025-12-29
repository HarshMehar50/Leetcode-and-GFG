class Solution {
    public int countSubarrays(int[] nums, int k) {
        /*int[] a = new int[nums.length];
        int ki = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == k){
            a[i] = 0;
            ki = i;
            }else if(nums[i] > k)
            a[i] = 1;
            else
            a[i] = -1;
        }
        int ans = 0;
        HashMap<Integer , Integer> map1 = new HashMap<>();
        HashMap<Integer , Integer> map2 = new HashMap<>();
        map1.put(0 , 1);
        map2.put(0 , -1);
        int ps = 0;
        for(int i = 0; i < nums.length; i++){
            ps += a[i];
            int i1 = map2.getOrDefault(ps , Integer.MAX_VALUE);
            int i2 = map2.getOrDefault(ps-1 , Integer.MAX_VALUE);
            if(i1 <= ki && ki <= i)
            ans += map1.getOrDefault(ps , 0);
            if(i2 <= ki && ki <= i)
            ans += map1.getOrDefault(ps-1 , 0);
            map1.put(ps , map1.getOrDefault(ps , 0)+1);
            map2.put(ps , i);
        }
        return ans;*/
        int[] a = new int[nums.length];
        int ki = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == k){
            a[i] = 0;
            ki = i;
            }else if(nums[i] > k)
            a[i] = 1;
            else
            a[i] = -1;
        }
        int ans = 0;
        HashMap<Integer , Integer> f = new HashMap<>();
        f.put(0 , 1);
        int ps = 0;
        for(int i = ki-1; i >= 0; i--){
            ps += a[i];
            //ans += f.getOrDefault(ps , 0)+f.getOrDefault(ps-1 , 0);
            f.put(ps , f.getOrDefault(ps , 0)+1);
        }
        ps = 0;
        for(int i = ki; i < a.length; i++){
            ps += a[i];
            ans += f.getOrDefault(-ps , 0)+f.getOrDefault(1-ps , 0);
            //f.put(ps , f.getOrDefault(ps , 0)+1);
        }
        return ans;
    }
}