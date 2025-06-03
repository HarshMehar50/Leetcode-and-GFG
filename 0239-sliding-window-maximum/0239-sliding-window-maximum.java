class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(dq.peekFirst() == i-k)
            dq.pollFirst();
            if(i >= k-1)
            ans.add(nums[dq.peekFirst()]);
        }
        int[] fans = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            fans[i] = ans.get(i);
        }
        return fans;
    }
}