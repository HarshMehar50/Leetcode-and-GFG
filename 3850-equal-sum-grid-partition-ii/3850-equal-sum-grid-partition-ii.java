class Solution {
    boolean connected(int[] a , int sr , int er , int sc , int ec){
        if(er-sr+1 <= 1){
            if(a[1] != sc && a[1] != ec)
            return false;
        }
        if(ec-sc+1 <= 1){
            if(a[0] != sr && a[0] != er)
            return false;
        }
        return true;
    }
    public boolean canPartitionGrid(int[][] grid) {
        HashMap<Integer , List<int[]>> map = new HashMap<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                map.put(grid[i][j] , new ArrayList<>());
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                map.get(grid[i][j]).add(new int[]{i , j});
            }
        }
        int[][] ps = new int[grid.length][grid[0].length];
        ps[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++){
            ps[i][0] = ps[i-1][0]+grid[i][0];
        }
        for(int i = 1; i < grid[0].length; i++){
            ps[0][i] = ps[0][i-1]+grid[0][i];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                ps[i][j] = ps[i-1][j]+ps[i][j-1]+grid[i][j]-ps[i-1][j-1];
            }
        }
        int t = ps[ps.length-1][ps[0].length-1];
        for(int i = 0; i < ps[0].length-1; i++){
            int l = ps[ps.length-1][i];
            int r = t-l;
            if(l == r)
            return true;
            else if(l < r){
                int d = r-l;
                if(map.containsKey(d)){
                    for(int[] a : map.get(d)){
                        if(a[1] <= ps[0].length-1 && a[1] > i && connected(a , 0 , ps.length-1 , i+1 , ps[0].length-1))
                        return true;
                    }
                }
            }else{
                int d = l-r;
                if(map.containsKey(d)){
                    for(int[] a : map.get(d)){
                        if(a[1] >= 0 && a[1] <= i && connected(a , 0 , ps.length-1 , 0 , i))
                        return true;
                    }
                }
            }
        }
        for(int i = 0; i < ps.length-1; i++){
            int u = ps[i][ps[0].length-1];
            int l = t-u;
            if(u == l)
            return true;
            else if(u < l){
                int d = l-u;
                if(map.containsKey(d)){
                    for(int[] a : map.get(d)){
                        if(a[0] > i && a[0] < ps.length && connected(a , i+1 , ps.length-1 , 0 , ps[0].length-1))
                        return true;
                    }
                }
            }else{
                int d = u-l;
                if(map.containsKey(d)){
                    for(int[] a : map.get(d)){
                        if(a[0] >= 0 && a[0] <= i && connected(a , 0 , i , 0 , ps[0].length-1))
                        return true;
                    }
                }
            }
        }
        return false;
    }
}