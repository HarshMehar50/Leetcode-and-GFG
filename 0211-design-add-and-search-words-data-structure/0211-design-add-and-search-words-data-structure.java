class WordDictionary {
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
        
        boolean solve(String word , TrieNode node , int i){
            if(i >= word.length()){
                if(node.wordCount > 0)
                return true;
                else
                return false;
            }
            for(int j = 0; j < 26; j++){
                if(word.charAt(i) != '.'){
                    if(node.children[j] != null && j == (int)(word.charAt(i)-'a'))
                    if(solve(word , node.children[j] , i+1))
                    return true;
                }else{
                    if(node.children[j] != null)
                    if(solve(word , node.children[j] , i+1))
                    return true;
                }
            }
            return false;
        }
        public boolean search(String word) {
            /*TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) return false;
                node = node.children[idx];
            }
            return node.wordCount > 0;*/
            TrieNode node = root;
            return solve(word , node , 0);
        }
    }

    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return trie.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */