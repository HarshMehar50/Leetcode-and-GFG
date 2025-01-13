class Solution {
    public int minimumLength(String s) {
        HashMap<Character , Integer> f = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            f.put(s.charAt(i) , 0);
        }
        for(int i = 0; i < s.length(); i++){
            int v = f.get(s.charAt(i));
            f.put(s.charAt(i) , v+1);
        }
        int ans = 0;
        Set<Character> set = f.keySet();
        for(Character c : set){
            /*ans = ans-((f.get(c)/3)*2);
            int r = f.get(c)/3 + f.get(c)%3;
            ans = ans-(r/3)*2;*/
            if(f.get(c)%2 == 0)
            ans += 2;
            else
            ans += 1;
        }
        System.out.println(f);
        return ans;
    }
}