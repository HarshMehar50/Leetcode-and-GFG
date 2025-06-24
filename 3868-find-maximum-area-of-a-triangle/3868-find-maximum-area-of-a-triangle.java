class Solution {
    public long maxArea(int[][] coords) {
        HashMap<Integer , List<Integer>> yp = new HashMap<>();
        for(int i = 0; i < coords.length; i++){
            yp.put(coords[i][0] , new ArrayList<>());
        }
        for(int i = 0; i < coords.length; i++){
            yp.get(coords[i][0]).add(coords[i][1]);
        }
        HashMap<Integer , List<Integer>> xp = new HashMap<>();
        for(int i = 0; i < coords.length; i++){
            xp.put(coords[i][1] , new ArrayList<>());
        }
        for(int i = 0; i < coords.length; i++){
            xp.get(coords[i][1]).add(coords[i][0]);
        }
        long ypa = 0;
        int minx = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxy = Integer.MIN_VALUE;
        for(int i = 0; i < coords.length; i++){
            maxx = Math.max(maxx , coords[i][0]);
            minx = Math.min(minx , coords[i][0]);
            maxy = Math.max(maxy , coords[i][1]);
            miny = Math.min(miny , coords[i][1]);
        }
        for(Integer y : yp.keySet()){
            if(yp.get(y).size() >= 2){
                Collections.sort(yp.get(y));
                long a1 = (long)((long)(yp.get(y).get(yp.get(y).size()-1)-yp.get(y).get(0))*(long)(maxx-y));
                long a2 = (long)((long)(yp.get(y).get(yp.get(y).size()-1)-yp.get(y).get(0))*(long)(y-minx));
                ypa = Math.max(ypa , Math.max(a1 , a2));
            }
        }
        long xpa = 0;
        for(Integer x : xp.keySet()){
            if(xp.get(x).size() >= 2){
                Collections.sort(xp.get(x));
                long a1 = (long)((long)(xp.get(x).get(xp.get(x).size()-1)-xp.get(x).get(0))*(long)(maxy-x));
                long a2 = (long)((long)(xp.get(x).get(xp.get(x).size()-1)-xp.get(x).get(0))*(long)(x-miny));
                xpa = Math.max(xpa , Math.max(a1 , a2));
            }
        }
        long ans = Math.max(ypa , xpa);
        if(ans == 0)
            return -1;
        return ans;
    }
}