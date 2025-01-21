class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length())
        return "0";
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            if(s.isEmpty() || k <= 0)
            s.push(num.charAt(i));
            else{
                while(!s.isEmpty() && (int)num.charAt(i) < (int)s.peek() && k > 0){
                    s.pop();
                    k--;
                }
                s.push(num.charAt(i));
            }
        }
        String ans = "";
        int start = -1;
        for(int i = 0; i < s.size(); i++){
            if(s.get(i) != '0'){
                start = i;
                break;
            }
        }
        if(start == -1)
        return "0";
        for(int i = start; i < s.size(); i++){
            ans += s.get(i);
        }
        ans = ans.substring(0 , Math.min(ans.length() , num.length()-k));
        return ans;
    }
}