package pl.edu.pjwstk.mpr.twitter;

import java.util.ArrayList;

public class TweetBroadcast {

    private ArrayList<ITweetObserver> observers;
    private TweetGenerator generator;

    public TweetBroadcast() {
        observers = new ArrayList();
        generator = new TweetGenerator();
    }

    public void addObserver(ITweetObserver observer) {
        observers.add(observer);
    }

    public void sendTweet() {
        for (int i = 0; i < observers.size(); i++) {
            var tweet = generator.generate();
            observers.get(i).onTweet(tweet);
        }
    }

    public void run() {
        for (int x = 0; x < 5000; x++) {
            sendTweet();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
