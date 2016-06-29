package com.rresino.rx.main.connectables;

import com.rresino.rx.main.util.ThreadUtils;
import com.rresino.rx.main.util.TimeTicker;
import rx.observables.ConnectableObservable;

/**
 * Created by rresino on 28/02/2016.
 */
public class BasicConnectableObservableExample {

    public static void main(String[] args) {

        // New time ticker ever half second
        TimeTicker timeTicker = new TimeTicker(500);
        timeTicker.start();

        // Get observable with publish() method
        ConnectableObservable<Long> connectableObservable = timeTicker.toObservable().publish();

        // Add new subscriber
        connectableObservable.subscribe((x) -> {
            System.out.println("Ticker: "+System.currentTimeMillis()+" => "+x);
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
