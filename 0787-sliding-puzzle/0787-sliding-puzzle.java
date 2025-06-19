class Solution {
    String swap(String s , int index1 , int index2){
        char[] c = s.toCharArray();
        char temp = c[index1];
        c[index1] = c[index2];
        c[index2] = temp;
        return new String(c);
    }
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                start += Integer.toString(board[i][j]);
            }
        }
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(start);
        int n = 0;
        visited.add(start);
        while(!q.isEmpty()){
            int l = q.size();
            for(int i = 0; i < l; i++){
                String s = q.poll();
                if(s.equals(target))
                    return n;
                int index = s.indexOf('0');
                if(index+1 < 6 && index%3 != 2){
                    String t = swap(s , index , index+1);
                    if(!visited.contains(t)){
                        q.offer(t);
                        visited.add(t);
                    }
                }
                if(index-1 >= 0 && index%3 != 0){
                    String t = swap(s , index , index-1);
                    if(!visited.contains(t)){
                        q.offer(t);
                        visited.add(t);
                    }
                }
                if(index+3 < 6 && index/3 != 1){
                    String t = swap(s , index , index+3);
                    if(!visited.contains(t)){
                        q.offer(t);
                        visited.add(t);
                    }
                }
                if(index-3 >= 0 && index/3 != 0){
                    String t = swap(s , index , index-3);
                    if(!visited.contains(t)){
                        q.offer(t);
                        visited.add(t);
                    }
                }
            }
            n++;
        }
        return -1;
    }
}