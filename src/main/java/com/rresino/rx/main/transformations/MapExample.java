package com.rresino.rx.main.transformations;

import com.rresino.rx.main.util.Generator;
import rx.Observable;

/**
 * Created by rresino on 28/02/2016.
 */
public class MapExample {

    public static void main(String[] args) {

        System.out.println("Begin Map example of RX:");
        Observable.from(Generator.getGeekAlphabet())
                .map((letterGeek) -> {
                            return letterGeek.toUpperCase();
                }).subscribe((letterUpdated) -> {
                   System.out.println("Letter => "+letterUpdated);
                });
        System.out.println("End Map example of RX:");
        System.out.println("Begin FlatMap example of RX:");
        Observable.from(Generator.getGeekAlphabet())
                .flatMap((letterGeek) -> {
                            String[] result = {
                                    letterGeek.toUpperCase(),
                                    letterGeek.toLowerCase()
                            };

                            return Observable.from(result);
                        }).subscribe((letterUpdated) -> {
                    System.out.println("Letter => "+letterUpdated);
                });
        System.out.println("End FlatMap example of RX:");
    }
}
