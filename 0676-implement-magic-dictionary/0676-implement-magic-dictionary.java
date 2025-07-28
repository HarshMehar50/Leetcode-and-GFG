class MagicDictionary {
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
    public MagicDictionary() {
        trie = new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        for(int i = 0; i < dictionary.length; i++){
            trie.insert(dictionary[i]);
        }
    }
    
    public boolean search(String searchWord) {
        for(int i = 0; i < searchWord.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(c == searchWord.charAt(i)) 
                continue;
                StringBuilder sb = new StringBuilder(searchWord);
                sb.setCharAt(i , c);
                if(trie.search(sb.toString()))
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */