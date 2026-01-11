class Solution {
    String normalize(String s) {
        int shift = s.charAt(0)-'a';
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = (char)((s.charAt(i)-shift-'a'+26)%26 + 'a');
            sb.append(c);
        }
        return sb.toString();
    }
    public long countPairs(String[] words) {
        /*HashMap<String , Integer> f = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            f.put(words[i] , f.getOrDefault(words[i] , 0)+1);
        }
        long ans = 0;
        for(String s : words){
            StringBuilder sb = new StringBuilder(s);
            for(int i = 1; i < 26; i++){
                for(int j = 0; j < s.length(); i++){
                    sb.setCharAt(j , (char)((s.charAt(j)+i)%26));
                }
                ans += f.getOrDefault(sb.toString() , 0);
            }
        }
        return ans;*/
        HashMap<String , Long> f = new HashMap<>();
        long ans = 0;
        for(String s : words){
            String ns = normalize(s);
            long c = f.getOrDefault(ns , 0L);
            ans += c;
            f.put(ns , c+1);
        }
        return ans;
    }
}