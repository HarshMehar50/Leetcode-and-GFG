class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++){
            xor = xor^nums[i];
        }
        int db = xor&(-xor);
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if((nums[i]&db) == 0)
            l1.add(nums[i]);
            else
            l2.add(nums[i]);
        }
        int[] ans = new int[2];
        for(int i = 0; i < l1.size(); i++){
            ans[0] = ans[0]^l1.get(i);
        }
        for(int i = 0; i < l2.size(); i++){
            ans[1] = ans[1]^l2.get(i);
        }
        return ans;
    }
}