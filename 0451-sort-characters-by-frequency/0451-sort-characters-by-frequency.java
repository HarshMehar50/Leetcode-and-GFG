class Solution {
    public String frequencySort(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i) , 0);
        }
        for(int i = 0; i < s.length(); i++){
            int v = map.get(s.charAt(i));
            map.put(s.charAt(i) , v+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(y[1] , x[1]));
        for(Character c : map.keySet()){
            pq.offer(new int[]{(int)c , map.get(c)});
        }
        String ans = "";
        while(!pq.isEmpty()){
            char c = (char)pq.peek()[0];
            int f = pq.peek()[1];
            pq.poll();
            for(int i = 0; i < f; i++){
                ans += c;
            }
        }
        return ans;
    }
}