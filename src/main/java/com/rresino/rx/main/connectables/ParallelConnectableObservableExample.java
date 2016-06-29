package com.rresino.rx.main.connectables;

import com.rresino.rx.main.util.ThreadUtils;
import com.rresino.rx.main.util.TimeTicker;
import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;

/**
 * Created by rresino on 28/02/2016.
 */
public class ParallelConnectableObservableExample {

    public static void main(String[] args) {

        // New time ticker ever half second
        TimeTicker timeTicker = new TimeTicker(500);
        timeTicker.start();

        // Get observable with publish() method
        ConnectableObservable<Long> connectableObservable = timeTicker.toObservable().publish();

        // Add new subscriber
        connectableObservable
                .observeOn(Schedulers.computation())
                .subscribe((x) -> {
            System.out.println("Ticker 1: "+Thread.currentThread().getName()+" => "+x);
        });
        // Add new subscriber
        connectableObservable
                .observeOn(Schedulers.computation())
                .subscribe((x) -> {
            System.out.println("Ticker 2: "+Thread.currentThread().getName()+" => "+x);
        });

        ThreadUtils.sleep(2000);
        System.out.println("Let's begin...");
        connectableObservable.connect(); // Run the events emit
        ThreadUtils.sleep(3000);

        System.out.println("Let's stop all...");
        timeTicker.stop();
        System.out.println("End");
        System.exit(0);

    }
}
