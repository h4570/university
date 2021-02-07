package pl.edu.pjwstk.mpr.observer.listeners;

import pl.edu.pjwstk.mpr.observer.IAudioListener;

public class Ground implements IAudioListener {

    @Override
    public int getListenerId() {
        return 1;
    }

    @Override
    public void onAudioBeat(String message, int tick) {
        System.out.println("Ground got " + tick + " info from: " + message);
    }

}
