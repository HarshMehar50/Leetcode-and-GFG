class Solution {
    class TrieNode {
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

        public boolean search(String word , int s , int e) {
            TrieNode node = root;
            for(int i = s; i <= e; i++){
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (node.children[idx] == null) return false;
                node = node.children[idx];
            }
            return node.wordCount > 0;
        }
    }

    Trie trie;
    int solve(String s , boolean[][] present , int i){
        if(i >= s.length())
        return 0;
        int ans = s.length();
        for(int j = i; j < s.length(); j++){
            if(!present[i][j])
            ans = Math.min(ans , (j-i+1)+solve(s , present , j+1));
            else
            ans = Math.min(ans , solve(s , present , j+1));
        }
        return ans;
    }
    public int minExtraChar(String s, String[] dictionary) {
        trie = new Trie();
        for(int i = 0; i < dictionary.length; i++){
            trie.insert(dictionary[i]);
        }
        boolean[][] present = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                present[i][j] = trie.search(s , i , j);
            }
        }
        return solve(s , present , 0);
    }
}