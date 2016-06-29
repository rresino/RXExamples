package com.rresino.rx.main;

import com.rresino.rx.main.util.ThreadUtils;
import com.rresino.rx.main.util.TimeTicker;

import java.util.concurrent.TimeUnit;

/**
 * Created by rresino on 27/02/2016.
 */
public class MainExample1 {

    public static void main(String[] args) {

        TimeTicker ticker = new TimeTicker(10);
        ticker.start();

        try {
            ticker.toObservable()
                    // Send us a samples every second
                    .sample(1, TimeUnit.SECONDS)
                    .subscribe((t) -> {
                        // Emit event every 1 second
                        System.out.println("Tick: " + t);
                    });
            ThreadUtils.sleep(10000);
        } finally {
            // Call to stop and send onCompleted()
            ticker.stop();
        }

        System.exit(0);
    }
}
