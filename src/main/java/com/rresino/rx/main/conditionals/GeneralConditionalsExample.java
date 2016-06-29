package com.rresino.rx.main.conditionals;

import com.rresino.rx.main.util.Generator;
import rx.Observable;


/**
 * Created by rresino on 28/02/2016.
 */
public class GeneralConditionalsExample {

    public static void main(String[] args) {

        System.out.println("Begin defaultIfEmpty example of RX:");
        Observable.empty()
                .defaultIfEmpty("List/Stream empty")
                .subscribe((s)-> System.out.println(s));
        System.out.println();
        Observable.from(Generator.getGeekAlphabet())
                .defaultIfEmpty("List/Stream empty")
                .first()
                .subscribe((s)-> System.out.println(s));
        System.out.println("End defaultIfEmpty example of RX");
        System.out.println();

        System.out.println("Begin While example of RX:");

        Observable.from(Generator.getListIntegers(10))
                .skipWhile((i) -> {
                    return i < 8;
                }).subscribe((x) -> System.out.println(x));

        System.out.println();

        Observable.from(Generator.getListIntegers(10))
                .takeWhile((i) -> {
                    return i < 8;
                }).subscribe((x) -> System.out.println(x));

        System.out.println();

        /*
        Observable.from(Generator.getListIntegers(10))
                .takeWhileWithIndex((i, index) -> {
                    return index < 3;
                }).subscribe((x) -> System.out.println(x));
        */
        System.out.println("End While example of RX");
        System.exit(0);
    }
}

