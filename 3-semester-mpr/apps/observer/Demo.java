package pl.edu.pjwstk.mpr.observer;

import pl.edu.pjwstk.mpr.observer.listeners.Enemy;
import pl.edu.pjwstk.mpr.observer.listeners.Ground;
import pl.edu.pjwstk.mpr.observer.listeners.Player;
import pl.edu.pjwstk.mpr.observer.listeners.Tree;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        var song = new AudioBroadcast("Song");
        var adpcm = new AudioBroadcast("ADPCM");

        var player = new Player();
        var enemy = new Enemy();
        var ground = new Ground();
        var tree = new Tree();

        song.addListener(player);
        song.addListener(enemy);

        adpcm.addListener(ground);
        adpcm.addListener(tree);

        song.startDemoThread();
        adpcm.startDemoThread();
    }

}
