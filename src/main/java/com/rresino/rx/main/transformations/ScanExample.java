package com.rresino.rx.main.transformations;

import com.rresino.rx.main.util.Generator;
import rx.Observable;

/**
 * Created by rresino on 28/02/2016.
 */
public class ScanExample {

    public static void main(String[] args) {

        System.out.println("Begin Scan example of RX:");
        Observable.from(Generator.getGeekAlphabet())
                .scan(new StringBuilder(), (accumulator, step) -> {
                    return accumulator.append(step).append(',');
                })
                .subscribe((letterUpdated) -> {
            System.out.println("Result => "+letterUpdated);
        });
        System.out.println("End Scan example of RX");

        System.out.println("Begin Scan with Last example of RX:");
        Observable.from(Generator.getGeekAlphabet())
                .scan(new StringBuilder(), (accumulator, step) -> {
                    return accumulator.append(step).append(',');
                })
                .last()
                .subscribe((letterUpdated) -> {
                    System.out.println("Result => "+letterUpdated);
                });
        System.out.println("End Scan with Last example of RX");
    }
}
