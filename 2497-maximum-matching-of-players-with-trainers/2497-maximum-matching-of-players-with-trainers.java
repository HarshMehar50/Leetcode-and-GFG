class Solution {
    int ceil(int[] a , int x){
        int s = 0;
        int e = a.length-1;
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(a[m] < x)
            s = m+1;
            else{
                ans = m;
                e = m-1;
            }
        }
        return ans;
    }
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int ans = 0;
        /*boolean[] visited = new boolean[trainers.length];
        for(int i = 0; i < players.length; i++){
            int c = ceil(trainers , players[i]);
            if(c != -1){
                if(!visited[c]){
                    visited[c] = true;
                    ans++;
                }else{
                    for(int j = c+1; j < trainers.length; j++){
                        if(!visited[j]){
                            ans++;
                            visited[j] = true;
                            break;
                        }
                    }
                }
            }
        }*/
        int i = 0;
        int j = 0;
        while(i < players.length && j < trainers.length){
            if(players[i] <= trainers[j]){
                i++;
                j++;
                ans++;
            }else
            j++;
        }
        return ans;
    }
}