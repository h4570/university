/* Author: Sandro Sobczyński */

package com.company;

import java.util.ArrayList;

public class DemoRunners {

    public static void main(String[] args) {
        ArrayList<Runner> runners = new ArrayList<>();
        runners.add(new Athlete());
        runners.add(new PoliticalCandidate());
        runners.add(new Machine());
        for (Runner runner : runners) {
            runner.run();
        }
    }

}
