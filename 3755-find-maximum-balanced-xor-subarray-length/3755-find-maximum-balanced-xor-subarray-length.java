class Solution {
    public int maxBalancedSubarray(int[] nums) {
        int pxor = 0;
        HashMap<Pair<Integer , Integer> , Integer> map = new HashMap<>();
        map.put(new Pair<>(0 , 0) , -1);
        int ans = 0;
        int cp = 0;
        for(int i = 0; i < nums.length; i++){
            pxor = pxor^nums[i];
            if(nums[i]%2 == 0)
            cp++;
            else
            cp--;
            if(map.containsKey(new Pair<>(pxor , cp))){
                int index = map.get(new Pair<>(pxor , cp));
                ans = Math.max(ans , i-index);
            }else
            map.put(new Pair<>(pxor , cp) , i);
        }
        return ans;
    }
}