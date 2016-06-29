package com.rresino.rx.main.conditionals;

import com.rresino.rx.main.util.TimedEventSequence;
import com.rresino.rx.main.util.Generator;
import com.rresino.rx.main.util.ThreadUtils;
import rx.Observable;

import java.util.concurrent.TimeUnit;


/**
 * Created by rresino on 28/02/2016.
 */
public class TimeConditionalsExample {

    public static void main(String[] args) {

        System.out.println("Begin Time Conditionals example of RX:");

        TimedEventSequence<String> sequence1 = new TimedEventSequence<>(50L, Generator.getGeekAlphabet());
        TimedEventSequence<Integer> sequence2 = new TimedEventSequence<>(100L, Generator.getListIntegers(50));

        Observable.amb(sequence1.toObservable(), sequence2.toObservable())
                .subscribe((s) -> System.out.println(s));

        ThreadUtils.sleep(4000);

        System.out.println("End Time Conditionals example of RX");
        System.exit(0);
    }
}

