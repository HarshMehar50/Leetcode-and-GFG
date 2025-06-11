class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int wordCount = 0;
        int prefixCount = 0;
    }
    public static class Trie {
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
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(int i = 0; i < words.length; i++){
            trie.insert(words[i]);
        }
        boolean[] mark = new boolean[words.length];
        for(int i = 0; i < words.length; i++){
            int c = 0;
            for(int j = 0; j < words[i].length(); j++){
                if(trie.search(words[i].substring(0 , j+1)))
                c++;
            }
            if(c == words[i].length())
            mark[i] = true;
        }
        int maxl = 0;
        for(int i = 0; i < mark.length; i++){
            if(mark[i])
            maxl = Math.max(maxl , words[i].length());
        }
        List<String> set = new ArrayList<>();
        for(int i = 0; i < mark.length; i++){
            if(mark[i] && words[i].length() == maxl)
            set.add(words[i]);
        }
        Collections.sort(set);
        if(!set.isEmpty())
        return set.get(0);
        else
        return "";
    }
}