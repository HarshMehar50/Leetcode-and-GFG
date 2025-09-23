class Solution {
    boolean prime(int n){
        if(n <= 1)
        return false;
        if(n == 2 || n == 3 || n == 5)
        return true;
        for(int i = 2; i*i <= n; i++){
            if(n%i == 0)
            return false;
        }
        return true;
    }
    public int minOperations(int n, int m) {
        char[] g = {'0' , '1' , '2' , '3' , '4' , '5', '6' , '7' , '8' , '9'};
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        Set<Integer> visited = new HashSet<>();
        if(prime(n) || prime(m))
        return -1;
        pq.offer(new int[]{n , n});
        visited.add(n);
        while(!pq.isEmpty()){
            int node = pq.peek()[1];
            int d = pq.peek()[0];
            pq.poll();
            if(node == m)
            return d;
            StringBuilder sb = new StringBuilder(Integer.toString(node));
            for(int i = 0; i < sb.length(); i++){
                if((int)(sb.charAt(i)-'0')-1 >= 0){
                    char c = sb.charAt(i);
                    sb.setCharAt(i , g[(int)(sb.charAt(i)-'0')-1]);
                    int newnode = Integer.parseInt(sb.toString());
                    sb.setCharAt(i , c);
                    if(!visited.contains(newnode) && !prime(newnode)){
                        pq.offer(new int[]{d+newnode , newnode});
                        visited.add(newnode);
                    }
                }
                if((int)(sb.charAt(i)-'0')+1 < 10){
                    char c = sb.charAt(i);
                    sb.setCharAt(i , g[(int)(sb.charAt(i)-'0')+1]);
                    int newnode = Integer.parseInt(sb.toString());
                    sb.setCharAt(i , c);
                    if(!visited.contains(newnode) && !prime(newnode)){
                        pq.offer(new int[]{d+newnode , newnode});
                        visited.add(newnode);
                    }
                }
            }
        }
        return -1;
    }
}