class Solution {
    String solve(String s1 , String p){
        /*Stack<Character> s = new Stack<>();
        for(int i = 0; i < s1.length(); i++){
            if(!s.isEmpty() && s1.charAt(i) == p.charAt(1) && s.peek() == p.charAt(0))
            s.pop();
            else
            s.push(s1.charAt(i));
        }
        String ans = "";
        while(!s.isEmpty()){
            ans += s.pop();
        }
        String fans = "";
        for(int i = ans.length()-1; i >= 0; i--){
            fans += ans.charAt(i);
        }
        return fans;*/
        Stack<Character> s = new Stack<>();
        for(char c : s1.toCharArray()){
            if(!s.isEmpty() && c == p.charAt(1) && s.peek() == p.charAt(0))
            s.pop();
            else
            s.push(c);
        }
        StringBuilder ans = new StringBuilder();
        while(!s.isEmpty()){
            ans.append(s.pop());
        }
        return ans.reverse().toString();
    }
    public int maximumGain(String s, int x, int y) {
        int ans = 0;
        int n = s.length();
        String max = "";
        String min = "";
        if(x > y){
            max = "ab"; 
            min = "ba";
        }else if(x < y){
            max = "ba";
            min = "ab";
        }else{
            max = "ab";
            min = "ba";
        }
        String s1 = solve(s , max);
        ans += ((n-s1.length())/2)*Math.max(x , y);
        String s2 = solve(s1 , min);
        ans += ((s1.length()-s2.length())/2)*Math.min(x , y);
        return ans;
    }
}