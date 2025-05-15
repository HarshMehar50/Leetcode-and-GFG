class Solution {
    List<String> validChilds(StringBuilder s){
        List<String> valid = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            char c = s.charAt(i);
            char d = (c == '0')?'9':(char)(c-1);
            char in = (c == '9')?'0':(char)(c+1);
            s.setCharAt(i , d);
            String s1 = s.toString();
            valid.add(s1);
            s.setCharAt(i , in);
            String s2 = s.toString();
            valid.add(s2);
            s.setCharAt(i , c);
        }
        return valid;
    }
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < deadends.length; i++){
            set.add(deadends[i]);
        }
        Set<String> visited = new HashSet<>();
        if(set.contains("0000"))
            return -1;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        int level = 0;
        while(!q.isEmpty()){
            int l = q.size();
            for(int i = 0; i < l; i++){
                String node = q.poll();
                if(node.equals(target))
                    return level;
                StringBuilder s = new StringBuilder(node);
                List<String> valid = validChilds(s);
                for(int j = 0; j < valid.size(); j++){
                    if(!visited.contains(valid.get(j)) && !set.contains(valid.get(j))){
                        q.offer(valid.get(j));
                        visited.add(valid.get(j));
                    }
                }
            }
            level++;
        }
        return -1;
    }
}