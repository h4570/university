package pl.edu.pjwstk.mpr.observer.listeners;

import pl.edu.pjwstk.mpr.observer.IAudioListener;

public class Player implements IAudioListener {

    @Override
    public int getListenerId() {
        return 2;
    }

    @Override
    public void onAudioBeat(String message, int tick) {
        System.out.println("Player got " + tick + " info from: " + message);
    }

}
