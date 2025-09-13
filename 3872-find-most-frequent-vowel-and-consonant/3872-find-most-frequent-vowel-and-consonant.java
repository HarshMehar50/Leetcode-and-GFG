class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(char c = 'a'; c <= 'z'; c++){
            map.put(c , 0);
        }
        for(int i = 0; i < s.length(); i++){
            int v = map.get(s.charAt(i));
            map.put(s.charAt(i) , v+1);
        }
        int vmax = Math.max(map.get('a') , Math.max(map.get('e') , Math.max(map.get('i') , Math.max(map.get('o') , map.get('u')))));
        int cmax = 0;
        for(char c = 'b'; c <= 'z'; c++){
            if(c != 'e' && c != 'i' && c != 'o' && c != 'u')
                cmax = Math.max(map.get(c) , cmax);
        }
        return cmax+vmax;
    }
}