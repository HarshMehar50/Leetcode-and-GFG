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
        boolean solve(String word , TrieNode node , int i , int sc){
            if(i >= word.length()){
                if(sc == 1 && node.wordCount >= 1)
                return true;
                else
                return false;
            }
            if(sc > 1)
            return false;
            for(int j = 0; j < 26; j++){
                if(node.children[j] != null && j == word.charAt(i)-'a'){
                    if(solve(word , node.children[j] , i+1 , sc))
                    return true;
                }else if(node.children[j] != null && j != word.charAt(i)-'a'){
                    if(solve(word , node.children[j] , i+1 , sc+1))
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
            return solve(word , node , 0 , 0);

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
    Trie rtrie;
    public MagicDictionary() {
        trie = new Trie();
        rtrie = new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        for(int i = 0; i < dictionary.length; i++){
            trie.insert(dictionary[i]);
            rtrie.insert(new StringBuilder(dictionary[i]).reverse().toString());
        }
    }
    
    public boolean search(String searchWord) {
        /*for(int i = 0; i < searchWord.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(c == searchWord.charAt(i)) 
                continue;
                StringBuilder sb = new StringBuilder(searchWord);
                sb.setCharAt(i , c);
                if(trie.search(sb.toString()))
                return true;
            }
        }
        return false;*/
        
        /*String ts = searchWord.substring(1);
        String f1 = new StringBuilder(ts).reverse().toString();
        if(rtrie.startsWith(f1) && !trie.search(searchWord))
        return true;
        for(int i = 1; i < searchWord.length()-1; i++){
            String p = searchWord.substring(0 , i);
            String s = searchWord.substring(i+1);
            String fs = new StringBuilder(s).reverse().toString();
            if(trie.startsWith(p) && rtrie.startsWith(fs) && !trie.search(searchWord))
            return true;
        }
        if(trie.startsWith(searchWord.substring(0 , searchWord.length()-1)) && !trie.search(searchWord))
        return true;
        return false;*/

        return trie.search(searchWord);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */