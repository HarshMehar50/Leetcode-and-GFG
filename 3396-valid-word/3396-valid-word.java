class Solution {
    public boolean isValid(String word) {
        int vc = 0;
        int cc = 0;
        if(word.length() < 3)
        return false;
        List<Character> l = new ArrayList<>();
        l.add('a');
        l.add('A');
        l.add('e');
        l.add('E');
        l.add('i');
        l.add('I');
        l.add('o');
        l.add('O');
        l.add('u');
        l.add('U');
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) >= '0' && word.charAt(i) <= '9')
            continue;
            else if((word.charAt(i) >= 'a' && word.charAt(i) <= 'z')||(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')){
                if(l.contains(word.charAt(i)))
                vc++;
                else
                cc++;
            }else
            return false;
        }
        if(vc >= 1 && cc >= 1)
        return true;
        else
        return false;
    }
}