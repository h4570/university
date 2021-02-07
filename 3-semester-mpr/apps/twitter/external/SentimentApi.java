package pl.edu.pjwstk.mpr.twitter.external;

import pl.edu.pjwstk.mpr.twitter.Sentiment;

import java.util.Random;

public class SentimentApi {

    public static Sentiment getSentimentByText(String text) {
        return Sentiment.values()[new Random().nextInt(Sentiment.values().length)];
    }

}
