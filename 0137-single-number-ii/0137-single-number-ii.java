class Solution {
    public int singleNumber(int[] nums) {
        /*HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i] , 0);
        }
        for(int i = 0; i < nums.length; i++){
            int x = map.get(nums[i])+1;
            map.put(nums[i] , x);
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == 1){
                ans = nums[i];
                break;
            }
        }
        return ans;*/
        int[] b = new int[32];
        for(int i = 0; i <= 31; i++){
            int bs = 0;
            for(int j = 0; j < nums.length; j++){
                int bv = 0;
                if((nums[j]&(1<<i)) != 0)
                bv = 1;
                bs += bv;
            }
            b[i] = bs%3;
        }
        long ans = 0;
        for(int i = 0; i <= 31; i++){
            if(b[i] == 1)
            ans += (1<<i);
        }
        return (int)ans;
    }
}