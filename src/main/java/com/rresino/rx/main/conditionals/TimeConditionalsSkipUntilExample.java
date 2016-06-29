package com.rresino.rx.main.conditionals;

import com.rresino.rx.main.util.TimedEventSequence;
import com.rresino.rx.main.util.Generator;
import com.rresino.rx.main.util.ThreadUtils;
import com.rresino.rx.main.util.TimeTicker;
import rx.Observable;

import java.util.concurrent.TimeUnit;


/**
 * Created by rresino on 28/02/2016.
 */
public class TimeConditionalsSkipUntilExample {

    public static void main(String[] args) {

        System.out.println("Begin Time Conditionals example of RX:");

        TimedEventSequence<String> sequence1 = new TimedEventSequence<>(50L, Generator.getGeekAlphabet());
        TimeTicker timeTicker = new TimeTicker(3000);

        sequence1.toObservable().skipUntil(timeTicker.toObservable())
                .subscribe((x) -> System.out.println(x));
        timeTicker.start();

        ThreadUtils.sleep(5000);

        System.out.println("End Time Conditionals example of RX");
        System.exit(0);
    }
}

