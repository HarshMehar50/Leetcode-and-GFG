class Solution {
    void solve(String digits , List<Character>[] l , int i , StringBuilder sb , List<String> ans){
        if(i >= digits.length()){
            ans.add(sb.toString());
            return;
        }
        for(char c : l[digits.charAt(i)-'0']){
            sb.append(c);
            solve(digits , l , i+1 , sb , ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<Character>[] l = new ArrayList[10];
        for(int i = 0; i < 10; i++){
            l[i] = new ArrayList<>();
        } 
        l[2].add('a');
        l[2].add('b');
        l[2].add('c');
        l[3].add('d');
        l[3].add('e');
        l[3].add('f');
        l[4].add('g');
        l[4].add('h');
        l[4].add('i');
        l[5].add('j');
        l[5].add('k');
        l[5].add('l');
        l[6].add('m');
        l[6].add('n');
        l[6].add('o');
        l[7].add('p');
        l[7].add('q');
        l[7].add('r');
        l[7].add('s');
        l[8].add('t');
        l[8].add('u');
        l[8].add('v');
        l[9].add('w');
        l[9].add('x');
        l[9].add('y');
        l[9].add('z');
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(digits , l , 0 , sb , ans);
        return ans;
    }
}