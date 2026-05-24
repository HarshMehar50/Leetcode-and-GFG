class Solution {
    public int passwordStrength(String password) {
        Set<Character> lc = new HashSet<>();
        Set<Character> uc = new HashSet<>();
        Set<Character> d = new HashSet<>();
        Set<Character> sc = new HashSet<>();
        for(int i = 0; i < password.length(); i++){
            if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z')
                lc.add(password.charAt(i));
            else if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')
                uc.add(password.charAt(i));
            else if(password.charAt(i) >= '0' && password.charAt(i) <= '9')
                d.add(password.charAt(i));
            else
                sc.add(password.charAt(i));
        }
        return lc.size()+(2*uc.size())+(3*d.size())+(5*sc.size());
    }
}