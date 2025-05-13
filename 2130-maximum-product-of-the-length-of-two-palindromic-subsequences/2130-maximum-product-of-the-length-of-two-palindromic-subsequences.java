class Solution {
    boolean palindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r))
            return false;
            l++;
            r--;
        }
        return true;
    }
    public int maxProduct(String s) {
        List<Integer> l = new ArrayList<>();
        for(int mask = 0; mask < (1<<s.length()); mask++){
            String ps = "";
            for(int i = 0; i < s.length(); i++){
                if((mask&(1<<i)) != 0)
                ps += s.charAt(i);
            }
            if(palindrome(ps))
            l.add(mask);
        }
        Collections.sort(l);
        int ans = 0;
        for(int i = 0; i < l.size()-1; i++){
            for(int j = i+1; j < l.size(); j++){
                if((l.get(i)&l.get(j)) == 0)
                ans = Math.max(ans , Integer.bitCount(l.get(i))*Integer.bitCount(l.get(j)));
            }
        }
        return ans;
    }
}