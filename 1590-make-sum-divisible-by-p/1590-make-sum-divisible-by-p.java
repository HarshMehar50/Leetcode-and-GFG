class Solution {
    public int minSubarray(int[] nums, int p) {
        long ps = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , -1);
        long s = 0;
        for(int i = 0; i < nums.length; i++){
            s += nums[i];
        }
        long req = s%p;
        if(req == 0)
        return 0;
        int remove = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            ps += nums[i];
            long et = ps%p;
            long target = (et-req+p)%p;
            if(map.containsKey((int)target))
            remove = Math.min(remove , i-map.get((int)target));
            map.put((int)(ps%p) , i);
        }
        if(remove != nums.length)
        return remove;
        else
        return -1;
    }
}