class Solution {
    public int shortestSubarray(int[] nums, int k) {
        /*int ans = Integer.MAX_VALUE;
        int l = 0;
        int s = 0;
        for(int r = 0; r < nums.length; r++){
            s += nums[r];
            while(l <= r && s >= k){
                ans = Math.min(ans , r-l+1);
                s -= nums[l];
                l++;
            }
        }
        if(ans != Integer.MAX_VALUE)
        return ans;
        else
        return -1;*/
        long[] ps = new long[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            ps[i+1] = ps[i]+nums[i];
        }
        Deque<Integer> dq = new LinkedList<>();
        int ans = nums.length+1;
        for(int i = 0; i <= nums.length; i++){
            while(!dq.isEmpty() && ps[i]-ps[dq.peekFirst()] >= k){
                ans = Math.min(ans , i-dq.peekFirst());
                dq.pollFirst();
            }
            while(!dq.isEmpty() && ps[i] <= ps[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        if(ans != nums.length+1)
        return ans;
        else
        return -1;
    }
}