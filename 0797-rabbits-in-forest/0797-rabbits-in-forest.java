class Solution {
    public int numRabbits(int[] answers) {
        /*List<Integer> l = new ArrayList<>();
        for(int i = 0; i < answers.length; i++){
            if(!l.contains(answers[i]))
            l.add(answers[i]);
        }
        int s = 0;
        for(int i = 0; i < l.size(); i++){
            s += l.get(i);
        }
        s += l.size();
        return s;*/
        HashMap<Integer , Integer> f = new HashMap<>();
        for(int i = 0; i < answers.length; i++){
            f.put(answers[i] , 0);
        }
        for(int i = 0; i < answers.length; i++){
            int v = f.get(answers[i]);
            f.put(answers[i] , v+1);
        }
        int ans = 0;
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == 0)
                ans++;
            else{
                if(f.get(answers[i]) > 0)
                    ans += 1+answers[i];
                int v = f.get(answers[i]);
                f.put(answers[i] , v-(answers[i]+1));
            }
        }
        return ans;
    }
}