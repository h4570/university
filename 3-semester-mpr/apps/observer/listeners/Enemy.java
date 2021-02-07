package pl.edu.pjwstk.mpr.observer.listeners;

import pl.edu.pjwstk.mpr.observer.IAudioListener;

public class Enemy implements IAudioListener {

    @Override
    public int getListenerId() {
        return 0;
    }

    @Override
    public void onAudioBeat(String message, int tick) {
        System.out.println("Enemy got " + tick + " info from: " + message);
    }

}
