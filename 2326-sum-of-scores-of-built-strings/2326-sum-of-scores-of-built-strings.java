class Solution {
    /*class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int wordCount = 0;
        int prefixCount = 0;
    }
    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
                node.prefixCount++;
            }
            node.wordCount++;
        }

        public int search(String word , int s , int e) {
            TrieNode node = root;
            int l = 0;
            for (int i = s; i <= e; i++) {
                int idx = word.charAt(i) - 'a';
                if (node.children[idx] == null)
                return l;
                node = node.children[idx];
                l++;
            }
            return l;
        }
    }*/
    public long sumScores(String s) {
        long ans = 0;
        /*Trie trie = new Trie();
        trie.insert(s);
        for(int i = s.length()-1; i >= 0; i--){
            ans += trie.search(s , i , s.length()-1);
        }
        return ans;*/
        int[] z = new int[s.length()];
        int l = 0;
        int r = 0;
        for(int i = 1; i < s.length(); i++){
            if(i < r)
            z[i] = Math.min(r-i , z[i-l]);
            while(i+z[i] < s.length() && s.charAt(z[i]) == s.charAt(i+z[i])){
                z[i]++;
            }
            if(i+z[i] > r){
                l = i;
                r = i+z[i];
            }
        }
        for(int i = 0; i < z.length; i++){
            ans += z[i];
        }
        ans += s.length();
        return ans;
    }
}