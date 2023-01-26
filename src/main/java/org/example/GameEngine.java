package org.example;


import java.util.*;
import java.util.concurrent.*;

public class GameEngine {
    public static boolean stop = true;

    public void start() throws InterruptedException {
        Island island = new Island();
//        island.newDayStart();
//        island.newDayStart();



   //Starvation starvation = new Starvation();
        //Starvation st = new Starvation(this);
        //st.start();
    //starvation.start();
//
        while (true) {
            island.newDayStart();
            Thread.sleep(2000);
            }
        }
    }

