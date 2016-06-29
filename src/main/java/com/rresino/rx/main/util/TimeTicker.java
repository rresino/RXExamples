package com.rresino.rx.main.util;

import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by rresino on 27/02/2016.
 */
public class TimeTicker {

    private final BehaviorSubject<Long> tickerSubject;
    private final long interval;

    private volatile boolean paused;
    private long lastTick;
    private Thread tickerThread;

    public TimeTicker(long interval) {

        this.lastTick = System.currentTimeMillis();
        this.tickerSubject = BehaviorSubject.create(this.lastTick);
        this.tickerThread = null;
        this.paused = false;
        this.interval = interval;

    }

    public Observable<Long> toObservable() {
        return this.tickerSubject;
    }

    public synchronized void start() {
        if (this.tickerThread != null) {
            return; // Thicker thread is running
        }

        // Make sure to clear the paused flag
        unpaused();

        this.tickerThread = new Thread(() -> {
            try {
                while (Thread.interrupted() == false) {
                    // System.out.println("Inner loop: "+this.lastTick);
                    // To avoid overload the cpu
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        break;
                    }

                    // If it's paused do nothing
                    if (this.paused) {
                        continue;
                    }

                    // Get current time
                    long currentTime = System.currentTimeMillis();
                    if (currentTime - lastTick > interval) {
                        this.lastTick = currentTime;
                        tickerSubject.onNext(lastTick); // Emit a new event to subcribers
                    }
                }
            } catch (Throwable t) {
                // Notifier the error
                this.tickerSubject.onError(t);
            }

            this.tickerSubject.onCompleted();
        }, "TickerThread");

        this.tickerThread.start();
    }

    private synchronized void unpaused() {
        this.paused = false;
    }

    public synchronized void stop() {
        if (this.tickerThread == null) {
            return; // Thicker thread is not running
        }

        this.tickerThread.interrupt();
        try {
            this.tickerThread.join();

        } catch (InterruptedException e) {
            // Nothing
        }
    }


}
