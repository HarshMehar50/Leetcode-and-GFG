class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        TreeSet<Integer>[] set = new TreeSet[26];
        for(int i = 0; i < 26; i++){
            set[i] = new TreeSet<>();
        }
        for(int i = 0; i < s.length(); i++){
            set[s.charAt(i)-'a'].add(i);
        }
        int ans = 0;
        for(int i = 0; i < words.length; i++){
            int p = -1;
            for(int j = 0; j < words[i].length(); j++){
                if(set[words[i].charAt(j)-'a'].higher(p) == null){
                    ans++;
                    break;
                }
                p = set[words[i].charAt(j)-'a'].higher(p);
            }
        }
        return words.length-ans;
    }
}