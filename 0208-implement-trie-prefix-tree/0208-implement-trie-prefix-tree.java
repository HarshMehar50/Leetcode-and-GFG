class Trie {
    class TrieNode{
        boolean endOfWord;
        TrieNode[] children;
        public TrieNode(){
            endOfWord = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    TrieNode getNode(){
        return new TrieNode();
    }
    public void insert(String word) {
        TrieNode track = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i)-'a';
            if(track.children[index] == null)
            track.children[index] = getNode();
            track = track.children[index];
        }
        track.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode track = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i)-'a';
            if(track.children[index] == null)
            return false;
            track = track.children[index];
        }
        if(track != null && track.endOfWord)
        return true;
        else 
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode track = root;
        int i = 0;
        for(i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i)-'a';
            if(track.children[index] == null)
            return false;
            track = track.children[index];
        }
        if(i == prefix.length())
        return true;
        else 
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */