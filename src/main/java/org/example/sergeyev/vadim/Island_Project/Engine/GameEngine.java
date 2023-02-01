package org.example.sergeyev.vadim.Island_Project.Engine;


import org.example.sergeyev.vadim.Island_Project.Model.Island.Island;

public class GameEngine {
    public static boolean stop = true;

    public void start() throws InterruptedException {
        Island island = new Island();

        while (true) {
            island.newDayStart();
            Thread.sleep(2000);
            }
        }
    }

