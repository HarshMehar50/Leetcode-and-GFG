class Solution {
    public int minMoves(int[] nums) {
        if(nums.length == 1)
        return 0;
        int s = 0;
        int min = Integer.MAX_VALUE;
        HashMap<Integer , Integer> f = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            f.put(nums[i] , f.getOrDefault(nums[i] , 0)+1);
            s += nums[i];
            min = Math.min(min , nums[i]);
        }
        if(f.size() == 1)
        return 0;
        /*for(int i = 1; (long)((long)i*(long)nums.length) <= (long)(1e18); i++){
            if((long)((long)i*(long)nums.length) > s){
                if(((i*nums.length)-s)%(nums.length-1) == 0)
                return ((i*nums.length)-s)/(nums.length-1);
            }
        }
        return -1;*/
        return (s-(nums.length*min));
    }
}