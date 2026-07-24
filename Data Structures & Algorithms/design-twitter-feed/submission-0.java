// class Twitter {
    
    
//     class Tweet{
//         int tweetId;
//         int time;
//         public Tweet(int tweetId,int time) {
//             this.tweetId=tweetId;
//             this.time=time;
//         }
//     }
//     private Map<Integer,Set<Integer>>followMap;
//     private Map<Integer,List<Tweet>>tweetMap;
//     private int time;

//     public Twitter(){
//         followMap=new HashMap<>();
//         tweetMap=new HashMap<>();
//         time=0;
//     }
    
//     public void postTweet(int userId, int tweetId) {
//         //store userId and tweetId using map
//         tweetMap.putIfAbsent(userId,new ArrayList<>());
//         tweetMap.get(userId).add(new Tweet(tweetId,time++));
//     }
    
//     public List<Integer> getNewsFeed(int userId) {
//         //create a priority Queue  and check topmost element
//         // for user followee tweet list and show on 
//         // i think tweetid is ++ after any one post  i check followeeId base tweetid and 
//         //store in priorityQueue and show top most 10 tweets

//         //1.create a priorityQueue 
//         PriorityQueue<Tweet> heap=new PriorityQueue<>((a,b)->b.time-a.time);
//         //2.Set of user store also user and there follower
//         Set<Integer> users=new HashSet<>();
//        for (int u : users) {
//             if (tweetMap.containsKey(u)) {
//                 for (Tweet tweet : tweetMap.get(u)) {
//                     heap.offer(tweet);
//                 }
//             }       
//         }
        
//         users.add(userId);
//         users.addAll(followMap.get(userId));
    
//         //3.add all tweet in priorityQueue
//         for(Tweet tweets:tweetMap.get(users)){
//             heap.offer(tweets);
//         }
//         //4.create a list which add all tweetid
//         List<Integer> tweets=new ArrayList<>();
//         //5.store tweets<10
//         int i=0;
//         while(!heap.isEmpty() && i<10){
//             tweets.add(heap.poll().tweetId);
//             i++;
//         }
//         //6.display
//         return tweets;

//     }
    
//     public void follow(int followerId, int followeeId) {
//         //create a linkedlist to add follower and followee
//         followMap.putIfAbsent(followerId,new HashSet<>());
//         followMap.get(followerId).add(followeeId);
//     }
    
//     public void unfollow(int followerId, int followeeId) {
//         //check in liked list followeeId is present and delete
//         if(!followMap.containsKey(followerId)){
//             return;
//         }
//         followMap.get(followerId).remove(followeeId);
//     }
// }



class Twitter {

    class Tweet {
        int tweetId;
        int time;

        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;
    private int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {

        // Max Heap based on latest time
        PriorityQueue<Tweet> heap =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        // Users whose tweets should appear
        Set<Integer> users = new HashSet<>();
        users.add(userId);

        if (followMap.containsKey(userId)) {
            users.addAll(followMap.get(userId));
        }

        // Add all tweets of all users
        for (int u : users) {
            if (tweetMap.containsKey(u)) {
                for (Tweet tweet : tweetMap.get(u)) {
                    heap.offer(tweet);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!heap.isEmpty() && ans.size() < 10) {
            ans.add(heap.poll().tweetId);
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            return;
        }

        followMap.get(followerId).remove(followeeId);
    }
}