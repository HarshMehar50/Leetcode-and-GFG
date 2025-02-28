class Solution {
    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(min , nums[i]);
            max = Math.max(max , nums[i]);
        }
        int s = min;
        int e = max;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i] , i);
        }
        while(s < e){
            int m = s+(e-s)/2;
            List<Integer> l = new ArrayList<>();
            l.add(-2);
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= m && i-l.get(l.size()-1) > 1)
                l.add(i);
            }
            l.remove(0);
            if(l.size() >= k)
            e = m;
            else
            s = m+1;
            
        }
        return s;
    }
}