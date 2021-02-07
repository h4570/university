package pl.edu.pjwstk.mpr.observer.listeners;

import pl.edu.pjwstk.mpr.observer.IAudioListener;

public class Tree implements IAudioListener {

    @Override
    public int getListenerId() {
        return 3;
    }

    @Override
    public void onAudioBeat(String message, int tick) {
        System.out.println("Tree got " + tick + " info from: " + message);
    }

}
