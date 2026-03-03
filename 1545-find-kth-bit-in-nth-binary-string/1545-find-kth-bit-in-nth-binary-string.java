class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        for(int i = 1; i < n; i++){
            StringBuilder p = new StringBuilder(sb);
            p.reverse();
            for(int j = 0; j < p.length(); j++){
                p.setCharAt(j, p.charAt(j) == '0' ? '1' : '0');
            }
            sb.append("1").append(p);
        }
        return sb.charAt(k-1);
    }
}