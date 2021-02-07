package pl.edu.pjwstk.mpr.observer;

public class ExampleListener implements IAudioListener {

    private int lastTick;
    private int id;
    private String lastMessage;

    public ExampleListener(int id) {
        this.lastTick = -1;
        this.id = id;
    }

    @Override
    public int getListenerId() {
        return id;
    }

    @Override
    public void onAudioBeat(String message, int tick) {
        lastTick = tick;
        lastMessage = message;
    }

    public int getLastTick() {
        return lastTick;
    }

    public String getLastMessage() {
        return lastMessage;
    }

}
