package pl.edu.pjwstk.mpr.twitter.utils;

import pl.edu.pjwstk.mpr.twitter.Sentiment;

import java.util.ArrayList;

public class SentimentWeightArrayList extends ArrayList<SentimentWeight> {

    /**
     * A little dumb, but this is only mock.
     */
    public Sentiment getCurrentSentiment() {
        var love = 0;
        var excited = 0;
        var sad = 0;

        for (var sentWeight : this) {
            switch (sentWeight.sentiment) {
                case Sad -> sad += sentWeight.weight;
                case Love -> love += sentWeight.weight;
                case Excited -> excited += sentWeight.weight;
            }
        }

        if (love > excited)
            return love > sad ? Sentiment.Love : Sentiment.Sad;
        else
            return excited > sad ? Sentiment.Excited : Sentiment.Sad;
    }

}
