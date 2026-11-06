class Twitter {
    private record TweetInfo(int id, int timePosted){}
    private record TweetIndex(List<TweetInfo> tweets, int i){}

    private Map<Integer, Set<Integer>> followersMap;
    private Map<Integer, List<TweetInfo>> tweetMap;
    private int time;

    public Twitter() {
        followersMap = new HashMap<Integer, Set<Integer>>();
        tweetMap = new HashMap<Integer, List<TweetInfo>>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)){
            tweetMap.put(userId, new ArrayList<TweetInfo>());
        }
        tweetMap.get(userId).add(new TweetInfo(tweetId, this.time));
        ++time;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<TweetIndex> minHeap = new PriorityQueue<TweetIndex>(
            new Comparator<TweetIndex>(){
                @Override
                public int compare(TweetIndex a, TweetIndex b){
                    return Integer.compare(
                        a.tweets().get(a.i()).timePosted,
                        b.tweets().get(b.i()).timePosted
                    );
                }
            }.reversed()
        );

        List<List<TweetInfo>> tweets = new ArrayList<List<TweetInfo>>();
        if (followersMap.containsKey(userId)){
            for (Integer followee: followersMap.get(userId)){
                if (tweetMap.containsKey(followee)){
                    tweets.add(tweetMap.get(followee).reversed());
                }
            }
        }
        if (tweetMap.containsKey(userId)){
            tweets.add(tweetMap.get(userId).reversed());
        }

        List<TweetIndex> tweetIndices = new ArrayList<TweetIndex>();
        for (List<TweetInfo> tweet: tweets){
            tweetIndices.add(new TweetIndex(tweet, 0));
        }

        minHeap.addAll(tweetIndices);

        List<Integer> mostRecentTweets = new ArrayList<Integer>();
        while (mostRecentTweets.size() < 10 && !minHeap.isEmpty()){
            TweetIndex mostRecent = minHeap.poll();
            mostRecentTweets.add(mostRecent.tweets().get(mostRecent.i()).id);
            if (mostRecent.i() + 1 < mostRecent.tweets().size()){
                minHeap.offer(new TweetIndex(mostRecent.tweets(), mostRecent.i() + 1));
            }
        }

        return mostRecentTweets;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!followersMap.containsKey(followerId)){
            followersMap.put(followerId, new HashSet<Integer>());
        }
        followersMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followersMap.get(followerId).remove(followeeId);
    }
}
