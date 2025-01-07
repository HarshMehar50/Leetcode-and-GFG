class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<int[]> s = new Stack<>();
        /*for(int i = temperatures.length-1; i >= 0; i--){
            int span = 0;
            while(!s.isEmpty() && s.peek()[0] > temperatures[i]){
                span++;
                s.pop();
            }
            ans[i] = span;
            s.push(new int[]{temperatures[i] , span});
        }*/
        s.push(new int[]{temperatures[0] , 0});
        for(int i = 1; i < ans.length; i++){
            while(!s.isEmpty() && s.peek()[0] < temperatures[i]){
                ans[s.peek()[1]] = Math.abs(s.peek()[1]-i);
                s.pop();
            }
            s.push(new int[]{temperatures[i] , i});
        }
        return ans;
    }
}