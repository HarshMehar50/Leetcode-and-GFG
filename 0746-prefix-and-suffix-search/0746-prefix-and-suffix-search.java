class WordFilter {

    class TrieNode {
        TrieNode[] children = new TrieNode[27];
        int wordCount = 0;
        int prefixCount = 0;
        int index = -1;
    }
    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word , int i) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
                node.prefixCount++;
                node.index = Math.max(node.index , i);
            }
            node.wordCount++;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) return false;;
                node = node.children[idx];
            }
            if(node.wordCount > 0)
            return true;
            else
            return false;
        }

        public int startsWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) return -1;
                node = node.children[idx];
            }
            return node.index;
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

    }

    Trie trie;
    public WordFilter(String[] words) {
        trie = new Trie();
        for(int i = 0; i < words.length; i++){
            StringBuilder sb = new StringBuilder(words[i]);
            sb.append("{").append(words[i]);
            trie.insert(sb.toString() , i);
            for(int j = 0; j < words[i].length(); j++){
                sb.deleteCharAt(0);
                trie.insert(sb.toString() , i);
            }
        }
    }
    
    public int f(String pref, String suff) {
        StringBuilder sb = new StringBuilder(suff);
        sb.append("{").append(pref);
        return trie.startsWith(sb.toString());
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */