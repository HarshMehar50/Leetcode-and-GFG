class Solution {
    boolean check(int[] a , int[] b){
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i])
            return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length())
        return new ArrayList<>();
        int[] fp = new int[26];
        for(int i = 0; i < p.length(); i++){
            fp[p.charAt(i)-'a']++;
        }
        int[] fs = new int[26];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < p.length(); i++){
            fs[s.charAt(i)-'a']++;
        }
        if(check(fs , fp))
        ans.add(0);
        for(int i = p.length(); i < s.length(); i++){
            fs[s.charAt(i-p.length())-'a']--;
            fs[s.charAt(i)-'a']++;
            if(check(fs , fp))
            ans.add(i-p.length()+1);
        } 
        return ans;
    }
}