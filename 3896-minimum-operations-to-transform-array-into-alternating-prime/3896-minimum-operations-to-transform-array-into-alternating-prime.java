class Solution {
    public int minOperations(int[] nums) {
        /*TreeSet<Integer> prime = new TreeSet<>();
        TreeSet<Integer> nonprime = new TreeSet<>();
        boolean[] p = new boolean[100004];
        Arrays.fill(p , true);
        for(int i = 2; i < 100004; i++){
            if(p[i] && (long)i*(long)i < 100004){
                for(int j = i*i; j < 100004; j += i){
                    p[j] = false;
                }
            }
        }
        p[0] = false;
        p[1] = false;
        nonprime.add(0);
        nonprime.add(1);
        for(int i = 2; i < 100004; i++){
            if(p[i])
                prime.add(i);
            else
                nonprime.add(i);
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(i%2 == 0){
                if(!p[nums[i]]){
                    Integer c = prime.ceiling(nums[i]);
                    int dc = Integer.MAX_VALUE;
                    if(c != null)
                        dc = c-nums[i];
                    ans += dc;
                }
            }else{
                if(p[nums[i]]){
                    Integer c = nonprime.ceiling(nums[i]);
                    int dc = Integer.MAX_VALUE;
                    if(c != null)
                        dc = c-nums[i];
                    ans += dc;
                }
            }
        }
        return ans;*/
        boolean[] p = new boolean[100004];
        Arrays.fill(p , true);
        for(int i = 2; i < 100004; i++){
            if(p[i] && (long)i*(long)i < 100004){
                for(int j = i*i; j < 100004; j += i){
                    p[j] = false;
                }
            }
        }
        p[0] = false;
        p[1] = false;
        int[] nextPrime = new int[100004];
        int last = -1;
        for(int i = 100003; i >= 0; i--){
            if(p[i])
            last = i;
            nextPrime[i] = last;
        }
        int[] nextNonPrime = new int[100004];
        last = -1;
        for(int i = 100003; i >= 0; i--){
            if(!p[i])
            last = i;
            nextNonPrime[i] = last;
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(i%2 == 0){
                if(!p[nums[i]]){
                    if(nextPrime[nums[i]] != -1)
                    ans += nextPrime[nums[i]]-nums[i];
                }
            }else{
                if(p[nums[i]]){
                    if(nextNonPrime[nums[i]] != -1)
                    ans += nextNonPrime[nums[i]]-nums[i];
                }
            }
        }
        return ans;
    }
}