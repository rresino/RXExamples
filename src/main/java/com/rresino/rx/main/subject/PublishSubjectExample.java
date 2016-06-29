package com.rresino.rx.main.subject;

import com.rresino.rx.main.util.Generator;
import com.rresino.rx.main.util.ThreadUtils;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

/**
 * Created by rresino on 28/02/2016.
 */
public class PublishSubjectExample {

    public static void main(String[] args) {
        Object signal = new Object();

        synchronized (signal) {

            PublishSubject<String> subject = PublishSubject.create();

            subject.subscribe((x) -> {
                System.out.println("Letter : "+x);
                ThreadUtils.sleep(500);
                if ("eta".equalsIgnoreCase(x)) {
                    synchronized (signal) {
                        signal.notify();
                    }
                }
            });

            Observable.from(Generator.getGeekAlphabet())
                    .subscribeOn(Schedulers.computation())
                    .subscribe((letter) -> {
                        System.out.println("Sub1: "+letter);
                        subject.onNext(letter);
                    }, (t) -> {
                        subject.onError(t);
                    }, () -> {
                        System.out.println("End sub1");
                        subject.onCompleted();
                        synchronized (signal) {
                            signal.notify();
                        }
                    });

            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            subject.subscribe((letter) -> {
                System.out.println("Sub2: "+letter);
            }, (t) -> {
                subject.onError(t);
            }, () -> {
                System.out.println("End sub2");
            });

            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
