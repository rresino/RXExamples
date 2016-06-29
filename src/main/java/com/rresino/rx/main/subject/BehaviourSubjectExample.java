package com.rresino.rx.main.subject;

import com.rresino.rx.main.util.Generator;
import com.rresino.rx.main.util.ThreadUtils;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/**
 * Created by rresino on 28/02/2016.
 */
public class BehaviourSubjectExample {

    public static void main(String[] args) {

        BehaviorSubject<String> subject = BehaviorSubject.create("Start state");

        subject.subscribe((letter) -> System.out.println(letter));

        Observable.from(Generator.getGeekAlphabet())
                .subscribe(
                        (letter)->subject.onNext(letter),
                        (t)->subject.onError(t),
                        ()->{
                            System.out.println("onCompleted");
                            subject.onCompleted();
                        });

        subject.subscribe(
                (letter)-> System.out.println("Second sub: "+letter),
                (t)->subject.onError(t),
                ()->{
                    System.out.println("onCompleted 2");
                });
    }


}
