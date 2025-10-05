class StreamChecker {
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
            for(int i = e; i >= s; i--){
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (node.children[idx] == null) return false;
                node = node.children[idx];
                if(node.wordCount >0)
                return true;
            }
            return false;
        }
    }

    Trie trie;
    StringBuilder sb;
    int max = 0;
    public StreamChecker(String[] words) {
        trie = new Trie();
        for(int i = 0; i < words.length; i++){
            trie.insert(new StringBuilder(words[i]).reverse().toString());
            max = Math.max(words[i].length() , max);
        }
        sb = new StringBuilder();
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        return trie.search(sb.toString() , Math.max(0 , sb.length()-max) , sb.length()-1);
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */