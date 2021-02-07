package pl.edu.pjwstk.mpr.twitter;

import pl.edu.pjwstk.mpr.twitter.external.SentimentApi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Tweet {

    private String text;
    private Date creationDate;
    private Sentiment sentiment;

    public Tweet(String text, Date creationDate) {
        this.text = text;
        this.creationDate = creationDate;
    }

    public String getText() {
        return text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public List<String> getHashTags() {
        var result = new ArrayList<String>();
        var words = text.split("\\s+");
        var pattern = Pattern.compile("(?:^|\\s)(#[^ ]+)"); // hashfinder
        for (var word : words)
            if (pattern.matcher(word).matches())
                result.add(word.trim().toLowerCase());
        return result;
    }

    public Sentiment getSentiment() {
        if (sentiment == null)
            sentiment = SentimentApi.getSentimentByText(text);
        return sentiment;
    }

    public int getWeightByTime() {
        var howManySecondsAgo = (int) (new Date().getTime() - creationDate.getTime()) / 1000;
        if (1 >= howManySecondsAgo) // 0-1
            return 10;
        else if (3 >= howManySecondsAgo) // 2-3
            return 5;
        else // > 3
            return 1;
    }

}
