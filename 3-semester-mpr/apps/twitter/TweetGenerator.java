package pl.edu.pjwstk.mpr.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class TweetGenerator {

    public ArrayList<String> hashtags;

    public TweetGenerator() {
        this.hashtags = new ArrayList<>();
        feed();
    }

    public Tweet generate() {
        String[] firstWord = {"one", "two", "three"};
        String[] secondWord = {"four", "five", "six"};
        String[] thirdWord = {"seven", "eight", "nine"};
        String[] fourthWord = {"ten", "eleven", "twelve"};

        int rand1 = (int) (Math.random() * firstWord.length);
        int rand2 = (int) (Math.random() * secondWord.length);
        int rand3 = (int) (Math.random() * thirdWord.length);
        int rand4 = (int) (Math.random() * fourthWord.length);

        String randomHashtag = hashtags.get(new Random().nextInt(hashtags.size()));

        String tweetText = new StringBuilder(firstWord[rand1]).append(" ")
                .append(secondWord[rand2]).append(" ")
                .append(thirdWord[rand3]).append(" ")
                .append(fourthWord[rand4]).append(" ")
                .append(randomHashtag).toString();

        return new Tweet(tweetText, new Date());
    }


    private void feed() {
        String[] hashtagsList = new String[]{"#Trump", "#Coronavirus", "#Polska", "#Tesla", "#Bitcoin", "#Vaccine",
                "#Brexit", "#Netflix", "#Oscars"};

        hashtags.addAll(Arrays.asList(hashtagsList));
    }

}
