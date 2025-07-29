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
        
        boolean solve(String word , TrieNode node , int i , HashMap<String , Boolean> dp){
            if(i >= word.length()){
                if(node.wordCount > 0)
                return true;
                else
                return false;
            }
            String key = i+" "+System.identityHashCode(node);
            if(dp.containsKey(key))
            return dp.get(key);
            boolean ans = false;
            for(int j = 0; j < 26; j++){
                if(word.charAt(i) != '.'){
                    if(node.children[j] != null && j == (int)(word.charAt(i)-'a'))
                    ans = ans||solve(word , node.children[j] , i+1 , dp);
                }else{
                    if(node.children[j] != null)
                    ans = ans||solve(word , node.children[j] , i+1 , dp);
                }
            }
            dp.put(key , ans);
            return dp.get(key);
        }
        public boolean search(String word) {
            TrieNode node = root;
            HashMap<String , Boolean> dp = new HashMap<>();
            return solve(word , node , 0 , dp);
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