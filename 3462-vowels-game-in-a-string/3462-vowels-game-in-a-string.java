class Solution {
    public boolean doesAliceWin(String s) {
        int c = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
            c++;
        }
        if(c%2 == 1)
        return true;
        else{
            if(c != 0)
            return true;
            else
            return false;
        }
    }
}