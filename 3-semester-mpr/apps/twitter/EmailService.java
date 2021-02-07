package pl.edu.pjwstk.mpr.twitter;

public class EmailService {

    public static void sendEmail(String hashtag, Sentiment previous, Sentiment current) {
        System.out.println(String.format("Hashtag: %s changed from %s to %s", hashtag, previous.name(), current.name()));
    }

}
