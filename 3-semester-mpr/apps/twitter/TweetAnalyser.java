package pl.edu.pjwstk.mpr.twitter;

import java.util.ArrayList;

public class TweetAnalyser implements ITweetObserver {

    ArrayList<Hashtag> analyzedHashtags;

    public TweetAnalyser() {
        this.analyzedHashtags = new ArrayList<>();
    }

    @Override
    public void onTweet(Tweet tweet) {
        for (var hashtag : tweet.getHashTags()) {
            var foundObj = analyzedHashtags
                    .stream().filter(c -> c.getName().equals(hashtag))
                    .findAny();
            if (foundObj.isPresent())
                foundObj.get().addTweet(tweet);
            else {
                var newObj = new Hashtag(hashtag);
                newObj.addTweet(tweet);
                analyzedHashtags.add(newObj);
            }
        }
    }

}
