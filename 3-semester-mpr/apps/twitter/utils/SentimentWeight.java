package pl.edu.pjwstk.mpr.twitter.utils;

import pl.edu.pjwstk.mpr.twitter.Sentiment;

public class SentimentWeight {

    public final Sentiment sentiment;
    public final int weight;

    public SentimentWeight(Sentiment sentiment, int weight) {
        this.weight = weight;
        this.sentiment = sentiment;
    }
}
