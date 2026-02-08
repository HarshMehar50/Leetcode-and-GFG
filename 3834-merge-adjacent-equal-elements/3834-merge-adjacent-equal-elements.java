class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> s = new Stack<>();
        for(int i = 0; i < nums.length; i++){
            long e = nums[i];
            while(!s.isEmpty() && s.peek() == e){
                e = e+s.pop();
            }
            s.push(e);
        }
        List<Long> ans = new ArrayList<>();
        while(!s.isEmpty()){
            ans.add(s.pop());
        }
        Collections.reverse(ans);
        return ans;
    }
}