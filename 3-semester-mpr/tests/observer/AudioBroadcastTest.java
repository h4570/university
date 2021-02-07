package pl.edu.pjwstk.mpr.observer;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AudioBroadcastTest {

    @Test
    public void getListeners_is_size_1_after_1_addListener() {
        var obj = new AudioBroadcast("test");
        var listener = new ExampleListener(10);
        obj.addListener(listener);
        var listeners = obj.getListeners();
        assertThat(listeners.size() == 1);
    }

    @Test
    public void getListeners_have_proper_listener_after_addListener() {
        var obj = new AudioBroadcast("test");
        var listener = new ExampleListener(10);
        obj.addListener(listener);
        var listeners = obj.getListeners();
        var firstListener = listeners.get(0);
        assertThat(firstListener.getListenerId() == listener.getListenerId());
    }

    @Test
    public void sendSignalToAll_with_1_listener_tick() {
        var obj = new AudioBroadcast("test");
        var listener1 = new ExampleListener(10);
        obj.addListener(listener1);
        obj.sendSignalToAll();
        var res = listener1.getLastTick();
        assertThat(res == 10);
    }

    @Test
    public void sendSignalToAll_with_1_listener_msg() {
        var obj = new AudioBroadcast("test");
        var listener1 = new ExampleListener(10);
        obj.addListener(listener1);
        obj.sendSignalToAll();
        var res = listener1.getLastMessage();
        assertThat(res.equals("test"));
    }

    @Test
    public void sendSignalToAll_with_3_listeners() {
        var obj = new AudioBroadcast("test");
        var listener1 = new ExampleListener(10);
        var listener2 = new ExampleListener(10);
        var listener3 = new ExampleListener(10);
        obj.addListener(listener1);
        obj.addListener(listener2);
        obj.addListener(listener3);
        var res = 0;
        obj.sendSignalToAll();
        res += listener1.getLastTick();
        res += listener2.getLastTick();
        res += listener3.getLastTick();
        assertThat(res == 30);
    }

}
