class Twitter {
    HashMap<Integer , List<int[]>> tweets;
    HashMap<Integer , Set<Integer>> follows;
    int t;
    public Twitter() {
       tweets = new HashMap<>();
       follows = new HashMap<>();
       t = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId))
        tweets.put(userId , new ArrayList<>());
        tweets.get(userId).add(new int[]{t++ , tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        if(tweets.containsKey(userId)){
            for(int[] a : tweets.get(userId)){
                pq.offer(a);
                if(pq.size() > 10)
                pq.poll();
            }
        }
        if(follows.containsKey(userId)){
            for(Integer x : follows.get(userId)){
                if(tweets.containsKey(x)){
                    for(int[] a : tweets.get(x)){
                        pq.offer(a);
                        if(pq.size() > 10)
                        pq.poll();
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.peek()[1]);
            pq.poll();
        }
        Collections.reverse(ans);
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!follows.containsKey(followerId))
        follows.put(followerId , new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId))
        if(follows.get(followerId).contains(followeeId))
        follows.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */