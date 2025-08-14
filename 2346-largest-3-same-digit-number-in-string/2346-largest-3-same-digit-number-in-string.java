class Solution {
    public String largestGoodInteger(String num) {
        List<Character> l = new ArrayList<>();
        for(int i = 1; i < num.length()-1; i++){
            if(num.charAt(i) == num.charAt(i-1) && num.charAt(i) == num.charAt(i+1))
            l.add(num.charAt(i));
        }
        if(l.isEmpty())
        return "";
        Collections.sort(l);
        StringBuilder ans = new StringBuilder();
        ans.append(l.get(l.size()-1)).append(l.get(l.size()-1)).append(l.get(l.size()-1));
        return ans.toString();
    }
}