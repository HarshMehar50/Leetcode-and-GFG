class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i] , new ArrayList<>());
        }
        for(int i = 0; i < nums.length; i++){
            map.get(nums[i]).add(i);
        }
        int ans = Integer.MAX_VALUE;
        for(List<Integer> l : map.values()){
            for(int i = 0; i < l.size()-2; i++){
                ans = Math.min(ans , 2*(l.get(i+2)-l.get(i)));
            }
        }
        if(ans == Integer.MAX_VALUE)
        return -1;
        return ans;
    }
}