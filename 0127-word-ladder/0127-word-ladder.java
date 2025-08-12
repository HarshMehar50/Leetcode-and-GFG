class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int l = 0;
        while(!q.isEmpty()){
            int s = q.size();
            l++;
            for(int i = 0; i < s; i++){
                String c = q.poll();
                for(int j = 0; j < c.length(); j++){
                    char[] temp = c.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        temp[j] = ch;
                        String newWord = new String(temp);
                        if(newWord.equals(endWord))
                        return l+1;
                        if(wordList.contains(newWord) && !visited.contains(newWord)){
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;*/
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        int length = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) {
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; i++) {
                    char old = wordArray[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        wordArray[i] = ch;
                        String newWord = new String(wordArray);

                        if (endSet.contains(newWord)) {
                            return length + 1;
                        }

                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            nextSet.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    wordArray[i] = old;
                }
            }
            beginSet = nextSet;
            length++;
        }
        return 0;
    }
}