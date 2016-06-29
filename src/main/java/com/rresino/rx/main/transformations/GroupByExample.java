package com.rresino.rx.main.transformations;

import com.rresino.rx.main.util.Generator;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rresino on 28/02/2016.
 */
public class GroupByExample {

    public static void main(String[] args) {

        System.out.println("Begin GroupBy example of RX:");
        Observable.from(Generator.getListIntegers(100))
            .groupBy((i) -> {
                return (0 == (i % 2)? "Even" : "Odd");
            })
            .subscribe((groupList) -> {
                System.out.println("Key: "+groupList.getKey()+"-----------------------------");
                groupList.subscribe((x) -> {
                    System.out.println("Key: "+groupList.getKey()+" Value: "+x);
                });
            });

        System.out.println("End GroupBy example of RX");

        System.out.println("Begin GroupBy 2 example of RX:");

        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();

        Observable.from(Generator.getListIntegers(100))
                .groupBy((i) -> {
                    return (0 == (i % 2)? "Even" : "Odd");
                }).subscribe((groupList) -> {
                    groupList.subscribe((x) -> {
                        if ("Even".equals(groupList.getKey())) {
                            evenList.add(x);
                        } else {
                            oddList.add(x);
                        }
                    });
                });

        System.out.println("Evens: ");
        evenList.forEach((i)-> System.out.println(i));
        System.out.println("Odds: ");
        oddList.forEach((i)-> System.out.println(i));
        System.out.println("End GroupBy 2 example of RX");
    }
}
