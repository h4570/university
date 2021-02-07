package pl.edu.pjwstk.mpr.observer;

public interface IAudioListener {

    int getListenerId();

    void onAudioBeat(String message, int tick);

}
