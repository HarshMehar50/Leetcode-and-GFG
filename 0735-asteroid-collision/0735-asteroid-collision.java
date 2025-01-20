class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        s.push(asteroids[0]);
        for(int i = 1; i < asteroids.length; i++){
            if(s.isEmpty() || s.peek()*asteroids[i] > 0)
            s.push(asteroids[i]);
            else{
                /*int t = -1;
                while(!s.isEmpty()){
                if(s.peek()*asteroids[i] < 0 && Math.abs(s.peek()) > Math.abs(asteroids[i]))
                break;
                else if(s.peek()*asteroids[i] < 0 && Math.abs(s.peek()) == Math.abs(asteroids[i])){
                    s.pop();
                    break;
                }else{
                    s.pop();
                    t = 0;
                }
                }
                if(t == 0)
                s.push(asteroids[i]);*/
                while(!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(asteroids[i])){
                    s.pop();
                }
                if(s.isEmpty() || s.peek() < 0)
                s.push(asteroids[i]);
                else if(s.peek() == Math.abs(asteroids[i]))
                s.pop();
            }
        }
        int[] ans = new int[s.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = s.get(i);
        }
        return ans;
    }
}