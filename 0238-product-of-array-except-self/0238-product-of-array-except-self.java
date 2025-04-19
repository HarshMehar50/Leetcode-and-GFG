class Solution {
    public int[] productExceptSelf(int[] nums) {
        List<Integer> z = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                z.add(i);
        }
        int[] ans = new int[nums.length];
        if(z.size() == 1){
            int p = 1;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0)
                    p = p*nums[i];
            }
            ans[z.get(0)] = p;
            return ans;
        }else if(z.size() == 0){
            int[] pp = new int[nums.length];
            pp[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                pp[i] = pp[i-1]*nums[i];
            }
            ans[0] = pp[nums.length-1]/nums[0];
            for(int i = 1; i < nums.length; i++){
                ans[i] = pp[i-1]*(pp[nums.length-1]/pp[i]);
            }
            return ans;
        }else{
            return ans;
        }
    }
}