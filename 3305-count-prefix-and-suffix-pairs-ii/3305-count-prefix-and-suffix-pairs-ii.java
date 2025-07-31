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
    List<Integer> LPS(String s){
        int[] lps = new int[s.length()];
        int l = 0;
        int i = 1;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(l)){
                l++;
                lps[i] = l;
                i++;
            }else{
                if(l != 0)
                l = lps[l-1];
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        int x = lps[s.length()-1];
        while (x > 0) {
            list.add(x);
            x = lps[x-1];
        }
        return list;
        //return lps[s.length()-1];
    }
    public long countPrefixSuffixPairs(String[] words) {
        Trie ts = new Trie();
        /*int[] lps = new int[words.length];
        for(int i = 0; i < words.length; i++){
            lps[i] = LPS(words[i]);
        }*/
        long ans = 0;
        ts.insert(words[0]);
        for(int i = 1; i < words.length; i++){
            /*for(int l = 1; l <= lps[i]; l++){
                ans += ts.countWordsEqualTo(words[i].substring(0 , l));
            }
            if(lps[i] != words[i].length())
            ans += ts.countWordsEqualTo(words[i]);*/
            List<Integer> l = LPS(words[i]);
            for(Integer x : l){
                ans += ts.countWordsEqualTo(words[i].substring(0 , x));
            }
            ans += ts.countWordsEqualTo(words[i]);
            ts.insert(words[i]);
        }
        return ans;
    }
}