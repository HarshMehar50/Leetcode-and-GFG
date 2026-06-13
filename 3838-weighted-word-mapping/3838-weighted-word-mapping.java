class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int[] a = new int[words.length];
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                a[i] += weights[words[i].charAt(j)-'a'];
            }
        }
        for(int i = 0; i < a.length; i++){
            a[i] = a[i]%26;
        }
        StringBuilder ans = new StringBuilder();
        List<Character> l = new ArrayList<>();
        for(char c = 'z'; c >= 'a'; c--){
            l.add(c);
        }
        for(int i = 0; i < a.length; i++){
            ans.append(l.get(a[i]));
        }
        return ans.toString();
    }
}