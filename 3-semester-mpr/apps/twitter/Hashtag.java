package pl.edu.pjwstk.mpr.twitter;

import pl.edu.pjwstk.mpr.twitter.utils.SentimentWeight;
import pl.edu.pjwstk.mpr.twitter.utils.SentimentWeightArrayList;

import java.util.ArrayList;

public class Hashtag {

    private String name;
    private Sentiment currentSentiment;
    private ArrayList<Tweet> tweets;

    public Hashtag(String name) {
        this.currentSentiment = Sentiment.None;
        this.name = name;
        tweets = new ArrayList<>();
    }

    public void addTweet(Tweet tweet) {
        this.tweets.add(tweet);
        think();
    }

    public String getName() {
        return name;
    }

    public Sentiment getCurrentSentiment() {
        return currentSentiment;
    }

    private void think() {
        if (tweets.size() == 1)
            currentSentiment = tweets.get(0).getSentiment();
        else {
            var calcArr = new SentimentWeightArrayList();
            for (var tweet : tweets)
                calcArr.add(new SentimentWeight(tweet.getSentiment(), tweet.getWeightByTime()));
            var thinkedSentiment = calcArr.getCurrentSentiment();
            if (thinkedSentiment != currentSentiment) {
                if (currentSentiment != Sentiment.None)
                    EmailService.sendEmail(name, currentSentiment, thinkedSentiment);
                currentSentiment = thinkedSentiment;
            }
        }
    }

}
