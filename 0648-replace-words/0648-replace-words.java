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

        public int lcp(String word) {
            TrieNode node = root;
            int l = 0;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null){
                    if(node.wordCount > 0)
                    return l;
                    else
                    return 0;
                }
                node = node.children[idx];
                l++;
                if(node.wordCount > 0)
                return l;
            }
            if(node.wordCount > 0)
            return l;
            else
            return 0;
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

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String s : dictionary){
            trie.insert(s);
        }
        List<String> l = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        li.add(0);
        StringBuilder sb = new StringBuilder(sentence);
        for(int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i) == ' ')
            li.add(i);
        } 
        li.add(sentence.length());
        for(int i = 0; i < li.size()-1; i++){
            if(sentence.charAt(li.get(i)) != ' ')
            l.add(sb.substring(li.get(i) , li.get(i+1)).toString());
            else
            l.add(sb.substring(li.get(i)+1 , li.get(i+1)).toString());
        }
        StringBuilder ans = new StringBuilder();
        for(String s : l){
            int lp = trie.lcp(s);
            if(lp != 0 )
            ans.append(s.substring(0 , lp)).append(" ");
            else
            ans.append(s).append(" ");
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }
}