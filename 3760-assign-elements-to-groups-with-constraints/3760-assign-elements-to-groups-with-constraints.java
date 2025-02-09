class Solution {
    /*int ceil(int[] a , int k){
        int s = 0;
        int e = a.length-1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(a[m] == k)
            return m;
            if(a[m] < k)
            s = m+1;
            else
            m = e-1;
        }
        return s;
    }*/
    public int[] assignElements(int[] groups, int[] elements) {
        /*int[] c = groups;
        Arrays.sort(c);
        int[][] a = new int[groups.length][2];
        for(int i = 0; i < groups.length; i++){
            a[i][0] = groups[i];
            a[i][1] = i;
        }
        int[] ans = new int[groups.length];
        boolean[] visited = new boolean[groups.length];
        Arrays.fill(ans , -1);
        Arrays.sort(a , (x , y)->Integer.compare(x[0] , y[0]));
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < elements.length; i++){
            if(!set.contains(elements[i])){
            int index = ceil(c , elements[i]);
            set.add(elements[i]);
            if(index != -1 && index < groups.length){
                for(int j = index; j < groups.length; j++){
                    if(a[j][0]%elements[i] == 0 && !visited[a[i][1]]){
                    ans[a[j][1]] = i;
                    visited[a[j][1]] = true;
                    break;
                    }
                }
            }
            }
        }
        return ans;*/
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < elements.length; i++){
            map.putIfAbsent(elements[i] , i);
        }
        int[] ans = new int[groups.length]; 
        for(int i = 0; i < groups.length; i++){
            int a = Integer.MAX_VALUE;
            for(int j = 1; j*j <= groups[i]; j++){
                if(groups[i]%j == 0 && map.containsKey(j))
                a = Math.min(a , map.get(j));
                if(groups[i]%j == 0 && j != groups[i] && map.containsKey(groups[i]/j))
                a = Math.min(a , map.get(groups[i]/j));
            }
            if(a == Integer.MAX_VALUE)
            ans[i] = -1;
            else
            ans[i] = a;
        }
        return ans;
    }
}