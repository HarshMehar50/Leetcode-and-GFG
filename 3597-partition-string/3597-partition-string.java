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
    }
    public List<String> partitionString(String s) {
        Trie trie = new Trie();
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(!trie.search(sb.toString())){
                trie.insert(sb.toString());
                ans.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return ans;
    }
}