class Solution {
    /*int lps(String s , String p){
        int l = 0;
        for(int i = 0; i < Math.min(s.length() , p.length()); i++){
            if(s.charAt(i) == p.charAt(i))
            l++;
            else
            break;
        }
        return l;
    }*/
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder);
        int i = 0;
        while(i < folder.length){
            ans.add(folder[i]);
            /*int j = 0;
            for(j = i+1; j < folder.length; j++){
                if(lps(folder[i] , folder[j]) != folder[i].length())
                break;
            }*/
            int j = i+1;
            while(j < folder.length && folder[j].startsWith(folder[i]+"/")){
                j++;
            }
            i = j;
        }
        return ans;
    }
}