package com.rresino.rx.main.transformations;

import com.rresino.rx.main.util.Generator;
import com.rresino.rx.main.util.ThreadUtils;
import com.rresino.rx.main.util.TimeTicker;
import rx.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by rresino on 28/02/2016.
 */
public class BufferExample {

    public static void main(String[] args) {

        System.out.println("Begin Buffer example of RX:");

        // Create a ticker that will go off 10 times per second (100ms)
        TimeTicker ticker = new TimeTicker(100);
        ticker.start();
        ticker.toObservable()
                .buffer(1, TimeUnit.SECONDS)
                .subscribe((list) -> {
                    System.out.println("Count: "+list.size()+"-------------------------------------------------------");
                    list.forEach((x) -> System.out.println(" - "+x));
                });

        System.out.println("End Buffer example of RX:");
        // Wait to ticker for 5 seconds
        ThreadUtils.sleep(5000);
        // Stop ticker
        ticker.stop();
        System.exit(0);
    }
}

