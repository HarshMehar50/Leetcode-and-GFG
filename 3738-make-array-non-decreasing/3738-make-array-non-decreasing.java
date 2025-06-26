class Solution {
    public int maximumPossibleSize(int[] nums) {
        Stack<int[]> s = new Stack<>();
        for(int i = 0; i < nums.length; i++){
            if(s.isEmpty() || nums[i] >= s.peek()[0])
            s.push(new int[]{nums[i] , i});
        }
        return s.size();
    }
}