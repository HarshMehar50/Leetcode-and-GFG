class Solution {
    public String getSmallestString(String s) {
        char[] a = s.toCharArray();
        for(int i = 0; i < s.length()-1; i++){
            if((s.charAt(i)-'0')%2 == (s.charAt(i+1)-'0')%2 && s.charAt(i) > s.charAt(i+1)){
                char t = a[i];
                a[i] = a[i+1];
                a[i+1] = t;
                break;
            }
        }
        return new String(a);
    }
}