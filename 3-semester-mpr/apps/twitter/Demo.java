package pl.edu.pjwstk.mpr.twitter;

public class Demo {

    public static void main(String[] args) {
        var broadcast = new TweetBroadcast();
        var listener = new TweetAnalyser();
        broadcast.addObserver(listener);
        broadcast.run(); // blocking way, but this is ok right now
    }

}
