class Solution {
    int colorId(char c){
        if(c == 'R')
        return 0;
        else if(c == 'B')
        return 1;
        else
        return 2;
    }
    public int findColoredRoot(int[][] edges, String colors) {
        int[] f = new int[3];
        for(int i = 0; i < colors.length(); i++){
            f[colorId(colors.charAt(i))]++;
        }
        int[] indegree = new int[colors.length()];
        int[] outdegree = new int[colors.length()];
        for(int[] e : edges){
            int cid0 = colorId(colors.charAt(e[0]));
            int cid1 = colorId(colors.charAt(e[1]));
            if(cid0 == cid1)
            return -1;
            if((cid0+1)%3 == cid1){
                outdegree[e[0]]++;
                indegree[e[1]]++;
            }else{
                outdegree[e[1]]++;
                indegree[e[0]]++;
            }
        }
        int root = -1;
        for(int i = 0; i < colors.length(); i++){
            if(outdegree[i] > 2)
            return -1;
            if(indegree[i] == 0){
                if(root != -1)
                return -1;
                root = i;
            }else if(indegree[i] != 1)
            return -1;
        }
        return root;
    }
}