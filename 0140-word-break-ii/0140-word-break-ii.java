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

        public boolean search(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) return false;
                node = node.children[idx];
            }
            return node.wordCount > 0;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) return false;
                node = node.children[idx];
            }
            return true;
        }

        public int countWordsEqualTo(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) return 0;
                node = node.children[idx];
            }
            return node.wordCount;
        }

        public int countWordsStartingWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) return 0;
                node = node.children[idx];
            }
            return node.prefixCount;
        }

        public void erase(String word) {
            if (!search(word)) return;
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                TrieNode child = node.children[idx];
                child.prefixCount--;
                node = child;
            }
            node.wordCount--;
        }
    }

    Trie trie;

    void solve(String s , int i , StringBuilder sb , List<String> ans){
        if(i >= s.length()){
            ans.add(sb.toString());
            return;
        }
        for(int j = i; j < s.length(); j++){
            if(trie.search(s.substring(i , j+1))){
                if(j+1 != s.length())
                sb.append(s.substring(i , j+1)+" ");
                else
                sb.append(s.substring(i , j+1));
                solve(s , j+1 , sb , ans);
                if(j+1 != s.length())
                sb.delete(sb.length()-(j-i+2) , sb.length());
                else
                sb.delete(sb.length()-(j-i+1) , sb.length());
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        trie = new Trie();
        for(int i = 0; i < wordDict.size(); i++){
            trie.insert(wordDict.get(i));
        }
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        solve(s , 0 , sb , ans);
        return ans; 
    }
}