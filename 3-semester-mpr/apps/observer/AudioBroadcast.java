package pl.edu.pjwstk.mpr.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AudioBroadcast {

    private String message;
    private int tick;
    private ArrayList<IAudioListener> listeners;
    Thread thread;

    public AudioBroadcast(String message) {
        listeners = new ArrayList();
        this.message = message;
        tick = 0;
    }

    public List<IAudioListener> getListeners() {
        return Collections.unmodifiableList(listeners);
    }

    public void addListener(IAudioListener listener) {
        listeners.add(listener);
    }

    public void sendSignalToAll() {
        for (int i = 0; i < listeners.size(); i++)
            listeners.get(i).onAudioBeat(message, tick);
    }

    public void startDemoThread() {
        Runnable task = () -> {
            for (int x = 0; x < 5; x++) {
                sendSignalToAll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tick++;
            }
        };
        task.run();
        thread = new Thread(task);
        thread.start();
    }

}